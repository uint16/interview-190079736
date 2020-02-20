package com.stock.market.Interview190079763.services;

import com.stock.market.Interview190079763.models.Stock;
import com.stock.market.Interview190079763.models.Trade;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * CalculationEngine
 */
public abstract class CalculationEngine {

    protected DataManager dataManager;

    @Autowired
    public CalculationEngine(DataManager dataManager){
        this.dataManager = dataManager;
    }

    public BigDecimal geometricMean(){

        var transactions = this.dataManager.getAllTransactions();
        var count = transactions.size();

        var product = transactions.stream().map(Trade::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::multiply);

        return BigDecimal.valueOf(Math.pow(product.doubleValue(), 1/count));
    }

    public BigDecimal volumeWeighedStockPrice(String ticker){
        var transactions = this.dataManager.getTransactionsForStock(ticker);
        var sumOfQuantities = transactions.stream().map(Trade::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);

        return transactions.stream().map(transaction -> transaction.getPrice()
                .multiply(transaction.getQuantity())
                .divide(sumOfQuantities)).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal profitToEarningsRatio(final Stock stock, final BigDecimal price){
        var dividends = stock.getLastDividend();
        return price.divide(dividends);
    }

    public abstract BigDecimal dividendYield(final String stockSymbol, final BigDecimal price);
    
}