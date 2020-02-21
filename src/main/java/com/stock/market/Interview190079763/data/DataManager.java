package com.stock.market.Interview190079763.data;

import com.stock.market.Interview190079763.models.Stock;
import com.stock.market.Interview190079763.models.StockType;
import com.stock.market.Interview190079763.models.Trade;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Scope(value = "singleton")
public class DataManager {

    private Map<String, Stock> data;
    private List<Trade> transactions;
    private static DataManager dataManager = new DataManager();

    private DataManager() {
        this.data = new HashMap<>();
        this.transactions = new ArrayList<>();

        //initial data
        data.put("TEA", new Stock.Builder("TEA").ofType(StockType.COMMON).lastDividend(BigDecimal.ZERO).fixedDividend(null).price(null).parValue(BigDecimal.valueOf(100)).build());
        data.put("POP", new Stock.Builder("POP").ofType(StockType.COMMON).lastDividend(BigDecimal.valueOf(8)).fixedDividend(null).price(null).parValue(BigDecimal.valueOf(100)).build());
        data.put("ALE", new Stock.Builder("ALE").ofType(StockType.COMMON).lastDividend(BigDecimal.valueOf(23)).fixedDividend(null).price(null).parValue(BigDecimal.valueOf(60)).build());
        data.put("GIN", new Stock.Builder("GIN").ofType(StockType.PREFERRED).lastDividend(BigDecimal.valueOf(8)).fixedDividend(BigDecimal.valueOf(2)).price(null).parValue(BigDecimal.valueOf(100)).build());
        data.put("JOE", new Stock.Builder("JOE").ofType(StockType.COMMON).lastDividend(BigDecimal.valueOf(13)).fixedDividend(null).price(null).parValue(BigDecimal.valueOf(250)).build());
    }

    public boolean addTrade(Trade trade) {
        if(data.containsKey(trade.getTicker()))
        {
            transactions.add(trade);
            return true;
        } else {
            return false;
        }
    }

    public Stock getDataForStock(String ticker) {
        return this.data.getOrDefault(ticker, null);
    }

    public List<Trade> getAllTransactions() {
        return this.transactions;
    }

    public List<Trade> getTransactionsForStock(String ticker) {
        var currentTime = LocalDateTime.now();
        var previousTime = currentTime.minusMinutes(15);

        return this.transactions.stream()
                .filter(transaction -> transaction.getTicker().equals(ticker) &&
                        transaction.getTimeStamp().isBefore(currentTime) &&
                        transaction.getTimeStamp().isAfter(previousTime))
                .collect(Collectors.toList());
    }

    public static DataManager getDataManager(){
        return dataManager;
    }

}
