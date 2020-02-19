package com.stock.market.Interview190079763.services;

import java.math.BigDecimal;

import com.stock.market.Interview190079763.models.Stock;

/**
 * CalculationEngine
 */
public abstract class CalculationEngine {

    public void geometricMean(){

    }

    public void volumeWeighedStockPrice(){

    }

    public void pAndERatio(final Stock stock, final BigDecimal price){

    }

    public abstract void dividendYield(final Stock stock, final BigDecimal price);
    
}