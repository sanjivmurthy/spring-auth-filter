package com.baeldung.bootcustomfilters.filters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.NotAuthorizedException;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

//@PreMatching
@Provider
@PreMatching
public class SecurityFilter implements javax.ws.rs.container.ContainerRequestFilter{
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        Logger LOG = LoggerFactory.getLogger(SecurityFilter.class);
//        LOG.info("requestContext CALLED");


        String AUTHORIZATION_PROPERTY = "auth";
        String APP_NAME = "app-name";
        String AUTHENTICATION_SCHEME = "Basic";
        Response ACCESS_DENIED = Response.status(Response.Status.UNAUTHORIZED).build();
        Response OK = Response.status(Response.Status.OK).build();
        // private static final Response ACCESS_FORBIDDEN = Response.status(Response.Status.FORBIDDEN).build();
        // private static final Response SERVER_ERROR = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();

        //Access allowed for all
        if( ! requestContext.getMethod().equals("GET"))
        {
            LOG.info("IF BLOCK: " + requestContext.getMethod());
            //Get request headers
            final MultivaluedMap<String, String> headers = requestContext.getHeaders();

            //Fetch authorization header
//            final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);
            final String authorization = headers.get(AUTHORIZATION_PROPERTY).get(0);

            //Fetch app-name header
//            final List<String> app_name = headers.get(APP_NAME);
            final String app_name = headers.get(APP_NAME).get(0);

            LOG.info("AUTH: " + authorization.toString());
            LOG.info("APP-NAME: " + app_name.toString());

            //If no authorization information present; block access
            if(authorization.equals("abc123") && app_name.equals("fast-r"))
            {
                System.out.println("auth header: " + authorization.toString());
                System.out.println("app header: " + app_name.toString());
                requestContext.abortWith(OK);
            }
            else{
                requestContext.abortWith(ACCESS_DENIED);
            }
        }
        else{
            LOG.info("ELSE BLOCK: " + requestContext.getMethod());
            requestContext.abortWith(OK);
        }

    }
}
