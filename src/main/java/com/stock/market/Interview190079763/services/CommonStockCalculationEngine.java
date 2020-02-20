package com.stock.market.Interview190079763.services;

import com.stock.market.Interview190079763.models.Stock;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class CommonStockCalculationEngine extends CalculationEngine {
    public CommonStockCalculationEngine(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public BigDecimal dividendYield(String stockSymbol, BigDecimal price) {
        var stock = dataManager.getData().get(stockSymbol);
        return stock.getLastDividend().divide(price, RoundingMode.HALF_UP);
    }
}
