package com.stock.market.Interview190079763.data;

import com.stock.market.Interview190079763.models.Stock;
import com.stock.market.Interview190079763.models.StockType;
import com.stock.market.Interview190079763.models.Trade;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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

    public DataManager() {
        this.data = new HashMap<>();
        this.transactions = new ArrayList<>();

        //initial data
        data.put("TEA", new Stock("TEA", BigDecimal.valueOf(0), null, null, BigDecimal.valueOf(100), StockType.COMMON));
        data.put("POP", new Stock("POP", BigDecimal.valueOf(8), null, null, BigDecimal.valueOf(100), StockType.COMMON));
        data.put("ALE", new Stock("ALE", BigDecimal.valueOf(23), null, null, BigDecimal.valueOf(60), StockType.COMMON));
        data.put("GIN", new Stock("GIN", BigDecimal.valueOf(8), BigDecimal.valueOf(2), null, BigDecimal.valueOf(100), StockType.PREFERRED));
        data.put("JOE", new Stock("JOE", BigDecimal.valueOf(13), null, null, BigDecimal.valueOf(250), StockType.COMMON));
    }

    public void addTrade(Trade trade) {
        transactions.add(trade);
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
                .filter(transaction -> transaction.getTradedStock().getSymbol().equals(ticker) &&
                        transaction.getTimeStamp().isBefore(currentTime) &&
                        transaction.getTimeStamp().isAfter(previousTime))
                .collect(Collectors.toList());
    }
}
