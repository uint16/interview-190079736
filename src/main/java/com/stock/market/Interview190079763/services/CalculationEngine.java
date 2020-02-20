package com.stock.market.Interview190079763.services;

import com.stock.market.Interview190079763.models.Stock;
import com.stock.market.Interview190079763.models.Trade;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * CalculationEngine
 */
public abstract class CalculationEngine {

    private DataManager dataManager;

    @Autowired
    public CalculationEngine(DataManager dataManager){
        this.dataManager = dataManager;
    }

    public void geometricMean(){

    }

    public BigDecimal volumeWeighedStockPrice(String ticker){
        var transactions = getRelevantTransactions(ticker);
        var sumOfQuantities = transactions.stream().map(Trade::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);

        return transactions.stream().map(transaction -> transaction.getPrice()
                .multiply(transaction.getQuantity())
                .divide(sumOfQuantities)).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private List<Trade> getRelevantTransactions(String ticker){
        var allTransactions = this.dataManager.getTransactions();
        var currentTime = LocalDateTime.now();
        var previousTime = currentTime.minusMinutes(15);
        var transactions = allTransactions.stream()
                .filter(transaction -> transaction.getTradedStock().getSymbol().equals(ticker) &&
                        transaction.getTimeStamp().isBefore(currentTime) &&
                        transaction.getTimeStamp().isAfter(previousTime))
                .collect(Collectors.toList());

        return transactions;
    }

    public void pAndERatio(final Stock stock, final BigDecimal price){

    }

    public abstract void dividendYield(final Stock stock, final BigDecimal price);
    
}