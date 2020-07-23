package com.baeldung.bootcustomfilters.resource;

import com.baeldung.bootcustomfilters.resource.SecurityFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig
{
    public JerseyConfig()
    {
        register(SecurityFilter.class);
        register(UserController.class);

//        register(UserResource.class);

    }
}