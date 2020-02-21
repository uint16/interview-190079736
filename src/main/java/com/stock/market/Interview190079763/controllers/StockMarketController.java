package com.stock.market.Interview190079763.controllers;

import com.stock.market.Interview190079763.models.StockType;
import com.stock.market.Interview190079763.models.TradeDirection;
import com.stock.market.Interview190079763.services.CommonStockCalculationEngine;
import com.stock.market.Interview190079763.services.PreferredStockCalculationEngine;
import com.stock.market.Interview190079763.services.TradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/stock")
public class StockMarketController {

    private static Logger logger = LoggerFactory.getLogger(StockMarketController.class);
    @Autowired
    private CommonStockCalculationEngine commonStockCalculationEngine;
    @Autowired
    private PreferredStockCalculationEngine preferredStockCalculationEngine;
    @Autowired
    private TradeService tradeService;

    @GetMapping(value = "/dividendYield/{stockSymbol}")
    public BigDecimal getDividendYield(@PathVariable String stockSymbol, @RequestParam StockType stockType, @RequestParam(required = true) double price){
        logger.info("Requested Dividend Yield for Stock " + stockSymbol + " for price " + price);
        if(stockType == StockType.COMMON){
            return commonStockCalculationEngine.dividendYield(stockSymbol, BigDecimal.valueOf(price));
        } else if(stockType == StockType.PREFERRED){
            return preferredStockCalculationEngine.dividendYield(stockSymbol, BigDecimal.valueOf(price));
        }

        return BigDecimal.ZERO;
    }

    @GetMapping(value = "/profitToEarningRatio")
    public BigDecimal getProfitToEarningRatio(@RequestParam String stockSymbol,  @RequestParam(required = true) BigDecimal price){

        return commonStockCalculationEngine.profitToEarningsRatio(stockSymbol, price);
    }

    @GetMapping(value = "/trade")
    public HttpStatus tradeStock(@RequestParam String stockSymbol, @RequestParam TradeDirection tradeDirection, @RequestParam(required = true) BigDecimal price, @RequestParam BigDecimal quantity){
        tradeService.record(stockSymbol,quantity,price,tradeDirection);

        return HttpStatus.OK;
    }
}
