package com.redhat.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.undertow.UndertowComponent;
import org.apache.camel.support.jsse.SSLContextParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProxyRoute extends RouteBuilder {

    @Autowired
    SSLContextParameters sslContextParameters;
    @Override
    public void configure() throws Exception {
        UndertowComponent undertowComponent = (UndertowComponent)getContext().getComponent("undertow");
        undertowComponent.setSslContextParameters(sslContextParameters);
        from("undertow:https://0.0.0.0:8443/?matchOnUriPrefix=true")
                .log(">>INPUT")
                .to("https://localhost:8080/?sslContextParameters=#configureSSL&bridgeEndpoint=true");
    }
}
