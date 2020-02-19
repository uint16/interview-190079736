package com.stock.market.Interview190079763.services;

import com.stock.market.Interview190079763.models.Stock;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Scope(value = "singleton")
public class DataManager {

    private HashMap<String, Stock> data;

    public void addTrade(){

    }
}
