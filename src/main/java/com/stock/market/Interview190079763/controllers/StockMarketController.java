package com.stock.market.Interview190079763.controllers;

import com.stock.market.Interview190079763.models.Stock;
import com.stock.market.Interview190079763.models.StockType;
import com.stock.market.Interview190079763.services.CalculationEngine;
import com.stock.market.Interview190079763.services.CommonStockCalculationEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/stock")
public class StockMarketController {

    private static Logger logger = LoggerFactory.getLogger(StockMarketController.class);
    private CommonStockCalculationEngine commonStockCalculationEngine;

    @GetMapping(value = "/dividendYield/{stockType}/{stockSymbol}")
    public BigDecimal getDividendYield(@PathVariable String stockSymbol, @PathVariable StockType stockType, @RequestParam(required = true) BigDecimal price){
        logger.info("Requested Dividend Yield for Stock " + stockSymbol + " for price " + price);
        return price;
    }
}
