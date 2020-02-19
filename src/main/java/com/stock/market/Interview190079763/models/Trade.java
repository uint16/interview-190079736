package com.stock.market.Interview190079763.models;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Trade
 */
public class Trade {

    private BigDecimal quantity;
    private BigDecimal price;
    private Date timeStamp;
    private TradeDirection tradeDirection;

    public BigDecimal getQuantity() {
        return quantity;
    }

    public TradeDirection getTradeDirection() {
        return tradeDirection;
    }

    public void setTradeDirection(TradeDirection tradeDirection) {
        this.tradeDirection = tradeDirection;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}