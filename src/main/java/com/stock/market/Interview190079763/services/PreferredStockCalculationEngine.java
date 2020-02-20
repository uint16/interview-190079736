package com.stock.market.Interview190079763.services;

import com.stock.market.Interview190079763.models.Stock;

import java.math.BigDecimal;

public class PreferredStockCalculationEngine extends CalculationEngine {
    public PreferredStockCalculationEngine(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public BigDecimal dividendYield(Stock stock, BigDecimal price) {
        return (stock.getFixedDividend().multiply(stock.getParValue())).divide(stock.getPrice().multiply(BigDecimal.valueOf(100)));
    }
}
