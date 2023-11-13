package com.redhat.route;

import com.redhat.pojo.EntityInput;
import com.redhat.pojo.EntityOutput;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class MySpringBootRouter extends RouteBuilder {

    @Override
    public void configure() {
       from("cxf:bean:cxfEndpoint")
               .to("log:cxfRouter?showAll=true&level=DEBUG")
               .process(exchange -> {
                   EntityInput entityInput = exchange.getIn().getBody(EntityInput.class);
                   log.info("WebService requested with "+entityInput.getName());
                   //TODO
                   // Business Logic
                   EntityOutput entityOutput  = new EntityOutput();
                   entityOutput.setEvent(new Date());
                   entityOutput.setId(entityInput.getId());
                   entityOutput.setInfo(UUID.randomUUID().toString());

                   exchange.getIn().setBody(entityOutput);
               })
               .to("stream:out");
    }

}
