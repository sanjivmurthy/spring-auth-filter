//package com.baeldung.bootcustomfilters.resource;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import javax.ws.rs.GET;
//
//import javax.annotation.Resource;
//import javax.annotation.security.DenyAll;
//import javax.annotation.security.PermitAll;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//
//@Controller
//@XmlAccessorType(XmlAccessType.NONE)
////@Path("/test")
//public class UserResource {
//    boolean activated = false;
//    private static final Logger LOG = LoggerFactory.getLogger(UserResource.class);
//    @Path("/auth")
//    @GET
////    @RequestMapping(value = "/auth", method = RequestMethod.GET)
////    @GetMapping("")
////    @PermitAll
//    public String auth()
//    {
//        LOG.info("Posting the auth key");
//        activated = true;
//        return "Paste this JSON payload for future POST/PUT requests. {\"app_name\": \"fast-r\", \"auth_key\": \"abc123\"}";
//    }
//
////    @PermitAll
////    @RequestMapping(value = "/get", method = RequestMethod.GET)
//    @Path("/get")
//    @GET
//    public String get() {return "sample get";}
//
//    @Path("/post")
//    @POST
////    @RequestMapping(value = "/post", method = RequestMethod.POST)
//    public String post() {return "dummy post";}
//
////    @DenyAll
//    @RequestMapping(value = "/put", method = RequestMethod.PUT)
//    public String put() {return "dummy put";}
//}
