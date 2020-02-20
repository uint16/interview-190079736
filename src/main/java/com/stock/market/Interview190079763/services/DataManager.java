package com.stock.market.Interview190079763.services;

import com.stock.market.Interview190079763.models.Stock;
import com.stock.market.Interview190079763.models.Trade;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Scope(value = "singleton")
public class DataManager {

    private Map<String, Stock> data;
    private List<Trade> transactions;

    public DataManager(){
        this.data = new HashMap<>();
        this.transactions = new ArrayList<>();
    }

    public void addTrade(Trade trade){
        transactions.add(trade);
    }

    public Map<String, Stock> getData() {
        return data;
    }

    public void setData(Map<String, Stock> data) {
        this.data = data;
    }

    public List<Trade> getTransactions(){
        return this.transactions;
    }
}
