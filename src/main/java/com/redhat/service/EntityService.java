package com.redhat.service;

import com.redhat.pojo.EntityInput;
import com.redhat.pojo.EntityOutput;
import lombok.extern.slf4j.Slf4j;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Date;
import java.util.UUID;

@WebService
@Slf4j
public class EntityService {

    @WebMethod
    public EntityOutput getEntity(EntityInput entityInput) throws Exception {
    // No need to implement the body as the request will flow through the camel route.
    return null;
    }
}
