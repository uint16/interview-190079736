package com.stock.market.Interview190079763.models;

import java.math.BigDecimal;
import java.util.List;

/**
 * Stock
 */
public class Stock {

    private String symbol;
    private StockType stockType;
    private int lastDividend;
    private double fixedDividend;
    private BigDecimal parValue;
    private BigDecimal price;

    public String getSymbol() {
        return symbol;
    }

    public int getLastDividend() {
        return lastDividend;
    }

    public void setLastDividend(int lastDividend) {
        this.lastDividend = lastDividend;
    }

    public double getFixedDividend() {
        return fixedDividend;
    }

    public void setFixedDividend(double fixedDividend) {
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