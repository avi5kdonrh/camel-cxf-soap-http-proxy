package com.redhat;

import com.redhat.service.EntityService;
import org.apache.camel.component.cxf.common.DataFormat;
import org.apache.camel.component.cxf.jaxws.CxfEndpoint;
import org.apache.camel.component.undertow.UndertowComponent;
import org.apache.camel.component.undertow.UndertowHostOptions;
import org.apache.camel.support.jsse.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.net.ssl.TrustManagerFactory;
import java.security.KeyStore;

@SpringBootApplication
public class MySpringBootApplication {

    /**
     * A main method to start this application.
     */
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }

    @Bean
    public CxfEndpoint cxfEndpoint() throws Exception {
        CxfEndpoint endpoint = new CxfEndpoint();
        endpoint.setServiceClass(EntityService.class);
        endpoint.setAddress("/getEntity");
        endpoint.setDataFormat(DataFormat.POJO);
       // endpoint.setSslContextParameters(configureSSL());
        return endpoint;
    }

    @Bean
    public SSLContextParameters configureSSL() throws Exception{
        KeyStoreParameters ksp = new KeyStoreParameters();
        ksp.setResource("classpath:keystore.jks");
        ksp.setPassword("password");
        KeyManagersParameters kmp = new KeyManagersParameters();
        kmp.setKeyStore(ksp);
        kmp.setKeyPassword("password");

        KeyStoreParameters tsp = new KeyStoreParameters();
        tsp.setResource("classpath:truststore.jks");
        tsp.setPassword("password");
        KeyManagersParameters tmp = new KeyManagersParameters();
        tmp.setKeyStore(tsp);

        SSLContextServerParameters scsp = new SSLContextServerParameters();
        SSLContextParameters scp = new SSLContextParameters();
        scp.setServerParameters(scsp);
        scp.setKeyManagers(kmp);
        TrustManagersParameters trustManagersParameters = new TrustManagersParameters();
        trustManagersParameters.setKeyStore(tsp);
        scp.setTrustManagers(trustManagersParameters);
        return scp;
    }



}
