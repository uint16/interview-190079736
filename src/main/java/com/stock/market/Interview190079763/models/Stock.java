package com.stock.market.Interview190079763.models;

import java.math.BigDecimal;
import java.util.List;

/**
 * Stock
 */
public class Stock {

    private String symbol;
    private StockType stockType;
    private BigDecimal lastDividend;
    private BigDecimal fixedDividend;
    private BigDecimal parValue;
    private BigDecimal price;

    public Stock(String symbol, BigDecimal lastDividend, BigDecimal fixedDividend, BigDecimal price, BigDecimal parValue, StockType stockType){
        this.symbol = symbol;
        this.lastDividend = lastDividend;
        this.fixedDividend = fixedDividend;
        this.price = price;
        this.stockType = stockType;
        this.parValue = parValue;
    }

    public String getSymbol() {
        return symbol;
    }

    public BigDecimal getLastDividend() {
        return lastDividend;
    }

    public void setLastDividend(BigDecimal lastDividend) {
        this.lastDividend = lastDividend;
    }

    public BigDecimal getFixedDividend() {
        return fixedDividend;
    }

    public void setFixedDividend(BigDecimal fixedDividend) {
        this.fixedDividend = fixedDividend;
    }

    public BigDecimal getParValue() {
        return parValue;
    }

    public void setParValue(BigDecimal parValue) {
        this.parValue = parValue;
    }

    public StockType getStockType() {
        return stockType;
    }

    public void setStockType(StockType stockType) {
        this.stockType = stockType;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}