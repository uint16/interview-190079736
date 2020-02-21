package com.stock.market.Interview190079763.services;

import com.stock.market.Interview190079763.data.DataManager;
import com.stock.market.Interview190079763.models.Trade;
import com.stock.market.Interview190079763.models.TradeDirection;
import com.stock.market.Interview190079763.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class TradeService {

    private DataManager dataManager;

    @Autowired
    public TradeService(DataManager dataManager){
        this.dataManager = dataManager;
    }

    public boolean recordTrade(String ticker, BigDecimal quantity, BigDecimal price, TradeDirection direction) {
        if(!ValidationUtil.isBigDecimalValid(quantity) || !ValidationUtil.isBigDecimalValid(price)){
            return false;
        }
            var tradeRecord = new Trade();
            tradeRecord.setPrice(price);
            tradeRecord.setQuantity(quantity);
            tradeRecord.setTradeDirection(direction);
            tradeRecord.setTimeStamp(LocalDateTime.now());
            tradeRecord.setTicker(ticker);
            return this.dataManager.addTrade(tradeRecord);
    }

    public List<Trade> getAllTradeRecords(Optional<LocalDateTime> from, Optional<LocalDateTime> to, Optional<String> ticker){
        return this.dataManager.getAllTransactions();
    }
}
