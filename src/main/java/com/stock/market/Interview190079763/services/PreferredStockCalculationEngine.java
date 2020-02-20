package com.stock.market.Interview190079763.services;

import com.stock.market.Interview190079763.models.Stock;

import java.math.BigDecimal;

public class PreferredStockCalculationEngine extends CalculationEngine {
    public PreferredStockCalculationEngine(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void dividendYield(Stock stock, BigDecimal price) {

    }
}
