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
import org.mockito.runners.MockitoJUnitRunner;

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
        Stock stock = new Stock.Builder("TEST").ofType(StockType.PREFERRED).lastDividend(BigDecimal.valueOf(8)).fixedDividend(BigDecimal.valueOf(2)).price(null).parValue(BigDecimal.valueOf(30)).build();
        when(dataManager.getDataForStock("TEST")).thenReturn(stock);
    }

    @Test
    public void testDividendYieldWithValid() throws StockMarketException {
        assertEquals("0.6000", calculationEngine.dividendYield("TEST", BigDecimal.ONE).toString());
    }

    @Test(expected = StockMarketException.class)
    public void testDividendYieldWithValidStockInvalidPrice() throws StockMarketException {
        calculationEngine.dividendYield("TEST", BigDecimal.ZERO);
    }

    @Test
    public void testDividendYieldWithValidStockValidPrice() throws StockMarketException {
        assertEquals("0.0600", calculationEngine.dividendYield("TEST", BigDecimal.TEN).toString());
    }

    @Test(expected = StockMarketException.class)
    public void testDividendYieldWithInvalidStockValidPrice() throws StockMarketException {
        calculationEngine.dividendYield("INVALID", BigDecimal.TEN);
    }
}