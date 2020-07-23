package com.baeldung.bootcustomfilters.resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.logging.Filter;
import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;

import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

import static jdk.nashorn.internal.objects.NativeMath.log;

//@PreMatching
@Priority(1)
@Provider
@PreMatching
public class SecurityFilter implements javax.ws.rs.container.ContainerRequestFilter{
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        Logger LOG = LoggerFactory.getLogger(SecurityFilter.class);
        String AUTHORIZATION_PROPERTY = "auth";
        String APP_NAME = "app-name";
        Response ACCESS_DENIED = Response.status(Response.Status.UNAUTHORIZED).build();
        Response OK = Response.status(Response.Status.OK).build();

        //Access allowed for all
        if( ! requestContext.getMethod().equals("GET"))
        {
            LOG.info("IF BLOCK, REQUEST IS: " + requestContext.getMethod());
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
//                requestContext.abortWith(OK);
                Response.accepted().entity("request OK").build();
                System.out.println("request OK");
            }
            else{
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("request failed").build());
//                Response.status(400).entity("failed").build();
                LOG.info("request failed");
            }
        }
        else{
            LOG.info("ELSE BLOCK, REQUEST IS: " + requestContext.getMethod());
//            requestContext.abortWith(OK);
            Response.accepted().entity("request OK").build();
            System.out.println("request OK");
        }

    }


//    public void filter(ContainerRequestContext reqContext) throws IOException {
//        System.out.println("-- request info --");
//        UriInfo uriInfo = reqContext.getUriInfo();
//        log(uriInfo, reqContext.getHeaders());
////        reqContext.abortWith(Response.accepted().build());
//        Response.accepted().build();
//    }
}


