package com.stock.market.Interview190079763.services;

import com.stock.market.Interview190079763.config.ApplicationConstants;
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
        if(price == BigDecimal.ZERO) {
            return BigDecimal.ZERO;
        }
        var stock = dataManager.getDataForStock(stockSymbol);
        if(stock == null ) {
            return BigDecimal.ZERO;
        }

        return stock.getLastDividend().divide(price, ApplicationConstants.PRECISION, RoundingMode.CEILING);
    }
}
