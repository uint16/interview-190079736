package com.stock.market.Interview190079763.services;

import com.stock.market.Interview190079763.config.ApplicationConstants;
import com.stock.market.Interview190079763.data.DataManager;
import com.stock.market.Interview190079763.exception.StockMarketException;
import com.stock.market.Interview190079763.models.Trade;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

        if(sumOfQuantities == BigDecimal.ZERO) {
            return BigDecimal.ZERO;
        }
        return transactions.stream().map(transaction -> transaction.getPrice()
                .multiply(transaction.getQuantity())
                .divide(sumOfQuantities)).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal profitToEarningsRatio(final String ticker, final BigDecimal price){
        var stock = dataManager.getDataForStock(ticker);
        if(stock == null) return BigDecimal.ZERO;
        var dividends = stock.getLastDividend();
        if(dividends == BigDecimal.ZERO) {
            return BigDecimal.ZERO;
        }
        return price.divide(dividends, ApplicationConstants.PRECISION, RoundingMode.CEILING);
    }

    public abstract BigDecimal dividendYield(final String stockSymbol, final BigDecimal price) throws StockMarketException;
    
}