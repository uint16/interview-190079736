package com.stock.market.Interview190079763.services;

import com.stock.market.Interview190079763.models.Stock;

import java.math.BigDecimal;

public class CommonStockCalculationEngine extends CalculationEngine {
    public CommonStockCalculationEngine(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public BigDecimal dividendYield(Stock stock, BigDecimal price) {
        return stock.getLastDividend().divide(price);
    }
}
