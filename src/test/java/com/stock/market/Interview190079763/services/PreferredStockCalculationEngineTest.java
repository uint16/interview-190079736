package com.stock.market.Interview190079763.services;

import com.stock.market.Interview190079763.data.DataManager;
import com.stock.market.Interview190079763.exception.StockMarketException;
import com.stock.market.Interview190079763.models.Stock;
import com.stock.market.Interview190079763.models.StockType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PreferredStockCalculationEngineTest {

    @InjectMocks
    PreferredStockCalculationEngine calculationEngine;

    @Mock
    DataManager dataManager;

    @Before
    public void init() {
        Stock stock = new Stock("TEST", BigDecimal.valueOf(8),
                BigDecimal.valueOf(2),BigDecimal.valueOf(25), BigDecimal.valueOf(30), StockType.PREFERRED);
        when(dataManager.getDataForStock("TEST")).thenReturn(stock);
    }

    @Test
    public void testDividendYieldWithValid() throws StockMarketException {
        assertEquals("0.0240", calculationEngine.dividendYield("TEST", BigDecimal.ONE).toString());
    }

    @Test (expected = StockMarketException.class)
    public void testDividendYieldWithValidStockInvalidPrice() throws StockMarketException {
        calculationEngine.dividendYield("TEST", BigDecimal.ZERO);
    }

    @Test
    public void testDividendYieldWithValidStockValidPrice() throws StockMarketException {
        assertEquals("0.0240", calculationEngine.dividendYield("TEST", BigDecimal.TEN).toString());
    }

    @Test (expected = StockMarketException.class)
    public void testDividendYieldWithInvalidStockValidPrice() throws StockMarketException {
        calculationEngine.dividendYield("INVALID", BigDecimal.TEN);
    }
}