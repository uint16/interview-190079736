package com.stock.market.Interview190079763.services;


import com.stock.market.Interview190079763.models.Stock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
class CalculationEngineTest {
    @Mock
    Stock sampleStock;

    @InjectMocks
    CalculationEngine calculationEngine;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void geometricMean() {
    }

    @Test
    void volumeWeighedStockPrice() {
    }

    @Test
    void profitToEarningsRatio() {
    }


}