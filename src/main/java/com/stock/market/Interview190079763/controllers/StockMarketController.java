package com.stock.market.Interview190079763.controllers;

import com.stock.market.Interview190079763.exception.StockMarketException;
import com.stock.market.Interview190079763.models.StockType;
import com.stock.market.Interview190079763.models.Trade;
import com.stock.market.Interview190079763.models.TradeDirection;
import com.stock.market.Interview190079763.services.CommonStockCalculationEngine;
import com.stock.market.Interview190079763.services.PreferredStockCalculationEngine;
import com.stock.market.Interview190079763.services.TradeService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    @ApiOperation(value = "Calculate dividend yield")
    @GetMapping(value = "/dividendYield/{stockSymbol}")
    public BigDecimal getDividendYield(@PathVariable String stockSymbol, @RequestParam StockType stockType, @RequestParam(required = true) BigDecimal price) throws StockMarketException {
        logger.info("Requested Dividend Yield for Stock " + stockSymbol + " for price " + price);

        if (stockType == StockType.COMMON) {
            return commonStockCalculationEngine.dividendYield(stockSymbol, price);
        } else if (stockType == StockType.PREFERRED) {
            return preferredStockCalculationEngine.dividendYield(stockSymbol, price);
        }

        return BigDecimal.ZERO;
    }

    @ApiOperation(value = "Calculate profit to earnings ratio")
    @GetMapping(value = "/profitToEarningRatio")
    public BigDecimal getProfitToEarningRatio(@RequestParam String ticker, @RequestParam(required = true) BigDecimal price) {

        return commonStockCalculationEngine.profitToEarningsRatio(ticker, price);
    }

    @ApiOperation(value = "Perform a trade on a stock")
    @GetMapping(value = "/trade")
    public String tradeStock(@RequestParam String ticker, @RequestParam TradeDirection tradeDirection, @RequestParam(required = true) BigDecimal price, @RequestParam BigDecimal quantity) {
        var response = tradeService.recordTrade(ticker, quantity, price, tradeDirection);
        if(!response){
            return "Stock doesn't exist, or invalid quantity/price";
        }

        return HttpStatus.OK.toString();
    }

    @ApiOperation(value = "Calculate the GBCE All Share Index using the geometric mean of prices for all stocks")
    @GetMapping(value = "/geometricMean")
    public BigDecimal getGeometricMean() {
        return commonStockCalculationEngine.geometricMean();

    }

    @ApiOperation(value = "Calculate Volume Weighted Stock Price based on trades in past 15 minutes")
    @GetMapping(value = "/volumeWeightedStockPrice")
    public BigDecimal getVolumeWeightedStockPrice(@RequestParam String ticker) {
        return commonStockCalculationEngine.volumeWeighedStockPrice(ticker);
    }


    @ApiOperation(value = "FOR TESTING ONLY - See all trades done during session")
    @GetMapping(value = "/viewTrades")
    public List<Trade> xGetAllTrades(@RequestParam Optional<String> ticker, @RequestParam Optional<LocalDateTime> from, @RequestParam Optional<LocalDateTime> to) {
        return tradeService.getAllTradeRecords(from, to, ticker);
    }
}
