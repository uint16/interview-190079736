package com.stock.market.Interview190079763.services;

import com.stock.market.Interview190079763.data.DataManager;
import com.stock.market.Interview190079763.models.Trade;
import com.stock.market.Interview190079763.models.TradeDirection;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class TradeServiceTest {


    private DataManager dataManager = DataManager.getDataManager();

    private TradeService tradeService;

    @BeforeEach
    public void init() {
        tradeService = new TradeService(dataManager);
    }

    @Test
    void recordValidTrade() {
        tradeService.recordTrade("ALE", BigDecimal.valueOf(2), BigDecimal.valueOf(4), TradeDirection.BUY);
        assert (tradeService.getAllTradeRecords(null, null, null).size() == 1);
    }

    @Test
    void recordInvalidTrade() {
        tradeService.recordTrade("TEST2", BigDecimal.valueOf(2), BigDecimal.valueOf(4), TradeDirection.BUY);
        assert (tradeService.getAllTradeRecords(null, null, null).size() == 1);
    }


    @Test
    void getAllTradeRecords() {
    }
}