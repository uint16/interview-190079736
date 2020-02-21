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
        if(price.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        var stock = dataManager.getDataForStock(stockSymbol);
        if(stock == null){
            return BigDecimal.ZERO;
        }
        return (stock.getFixedDividend().multiply(stock.getParValue())).divide(stock.getPrice().multiply(BigDecimal.valueOf(100)), ApplicationConstants.PRECISION, RoundingMode.CEILING);
    }
}
