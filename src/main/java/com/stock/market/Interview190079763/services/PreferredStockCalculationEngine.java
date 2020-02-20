package com.stock.market.Interview190079763.services;

import com.stock.market.Interview190079763.config.ApplicationConstants;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class PreferredStockCalculationEngine extends CalculationEngine {
    public PreferredStockCalculationEngine(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public BigDecimal dividendYield(String stockSymbol, BigDecimal price) {
        var stock = dataManager.getData().get(stockSymbol);
        return (stock.getFixedDividend().multiply(stock.getParValue())).divide(stock.getPrice().multiply(BigDecimal.valueOf(100)), ApplicationConstants.PRECISION, RoundingMode.CEILING);
    }
}
