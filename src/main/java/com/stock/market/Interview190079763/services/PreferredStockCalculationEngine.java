package com.stock.market.Interview190079763.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PreferredStockCalculationEngine extends CalculationEngine {
    public PreferredStockCalculationEngine(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public BigDecimal dividendYield(String stockSymbol, BigDecimal price) {
        var stock = dataManager.getData().get(stockSymbol);
        return (stock.getFixedDividend().multiply(stock.getParValue())).divide(stock.getPrice().multiply(BigDecimal.valueOf(100)), RoundingMode.HALF_UP);
    }
}
