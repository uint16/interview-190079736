package com.stock.market.Interview190079763;

import com.stock.market.Interview190079763.services.SimpleStockService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(SimpleStockService.class);
    }
}
