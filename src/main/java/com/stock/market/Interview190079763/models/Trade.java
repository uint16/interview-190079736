package com.stock.market.Interview190079763.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Trade
 */
public class Trade {

    private BigDecimal quantity;
    private BigDecimal price;
    //TODO: factor in UTC
    private LocalDateTime timeStamp;
    private TradeDirection tradeDirection;
    private String ticker;

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public TradeDirection getTradeDirection() {
        return tradeDirection;
    }

    public void setTradeDirection(TradeDirection tradeDirection) {
        this.tradeDirection = tradeDirection;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }
}