package com.stock.market.Interview190079763.services;

import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Service
@Path("/stock")
public class SimpleStockService {

    @GET
    @Produces("text/plain")
    public String hello(){
        return "Hello, World";
    }
}
