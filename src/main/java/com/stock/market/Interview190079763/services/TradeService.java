package com.stock.market.Interview190079763.services;

import com.stock.market.Interview190079763.data.DataManager;
import com.stock.market.Interview190079763.models.Trade;
import com.stock.market.Interview190079763.models.TradeDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class TradeService {

    @Autowired
    private DataManager dataManager;

    public void record(String ticker, BigDecimal quantity, BigDecimal price, TradeDirection direction) {
        var tradeRecord = new Trade();
        tradeRecord.setPrice(price);
        tradeRecord.setQuantity(quantity);
        tradeRecord.setTradeDirection(direction);
        tradeRecord.setTimeStamp(LocalDateTime.now());
        tradeRecord.setTicker(ticker);
        dataManager.addTrade(tradeRecord);

    }
}
