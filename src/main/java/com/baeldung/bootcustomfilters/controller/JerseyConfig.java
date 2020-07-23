package com.baeldung.bootcustomfilters.controller;


import com.baeldung.bootcustomfilters.filters.SecurityFilter;
import com.baeldung.bootcustomfilters.resource.UserResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig
{
    public JerseyConfig()
    {
        register(SecurityFilter.class);
        register(new UserResource());
    }
}