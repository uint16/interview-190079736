package com.stock.market.Interview190079763.services;

import com.stock.market.Interview190079763.config.ApplicationConstants;
import com.stock.market.Interview190079763.data.DataManager;
import com.stock.market.Interview190079763.exception.StockMarketException;
import com.stock.market.Interview190079763.util.ValidationUtil;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class PreferredStockCalculationEngine extends CalculationEngine {
    public PreferredStockCalculationEngine(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public BigDecimal dividendYield(String stockSymbol, BigDecimal price) throws StockMarketException {
        var stock = dataManager.getDataForStock(stockSymbol);
        if (stock == null || !ValidationUtil.isBigDecimalValid(price)) {
            throw new StockMarketException("Invalid stock/price");
        }
        return (stock.getFixedDividend().multiply(stock.getParValue())).divide(stock.getPrice().multiply(BigDecimal.valueOf(100)), ApplicationConstants.PRECISION, RoundingMode.CEILING);
    }
}
