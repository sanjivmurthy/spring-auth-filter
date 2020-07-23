package com.baeldung.bootcustomfilters.controller;


//import com.baeldung.bootcustomfilters.filters.SecurityFilter;
//import com.baeldung.bootcustomfilters.resource.UserResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Configuration;

@Component
public class JerseyConfig extends ResourceConfig
{
    public JerseyConfig()
    {
        register(UserController.class);
//        register(SecurityFilter.class);
//        register(UserResource.class);

    }
}