package com.stock.market.Interview190079763.models;

import java.math.BigDecimal;

/**
 * Stock
 */
public class Stock {

    private String ticker;
    private StockType stockType;
    private BigDecimal lastDividend;
    private BigDecimal fixedDividend;
    private BigDecimal parValue;
    private BigDecimal price;

    private Stock(){}

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public static class Builder {

        private String ticker;
        private StockType stockType;
        private BigDecimal lastDividend;
        private BigDecimal fixedDividend;
        private BigDecimal parValue;
        private BigDecimal price;
        public Builder(String ticker){
            this.ticker = ticker;
        }

        public Builder ofType(StockType stockType){
            this.stockType = stockType;
            return this;
        }

        public Builder lastDividend(BigDecimal lastDividend){
            this.lastDividend = lastDividend;
            return this;
        }

        public Builder fixedDividend(BigDecimal fixedDividend){
            this.fixedDividend = fixedDividend;
            return this;
        }

        public Builder parValue(BigDecimal parValue){
            this.parValue = parValue;
            return this;
        }

        public Builder price(BigDecimal price){
            this.price = price;
            return this;
        }

        public Stock build(){
            Stock stock = new Stock();
            stock.parValue = this.parValue;
            stock.ticker = this.ticker;
            stock.stockType = this.stockType;
            stock.lastDividend = this.lastDividend;
            stock.fixedDividend = this.fixedDividend;

            return stock;
        }
    }
}