package com.baeldung.bootcustomfilters.resource;

//import com.baeldung.bootcustomfilters.model.HeaderModel;
//import com.baeldung.bootcustomfilters.model.User;
//import com.baeldung.bootcustomfilters.resource.SecurityFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.ws.rs.core.Response;

/**
 * Rest controller for User
 * @author hemant
 *
 */
//@RestController
//@XmlAccessorType(XmlAccessType.NONE)
//@XmlRootElement(name = "users")
//@RestController
//@RequestMapping("/test")
//@XmlAccessorType(XmlAccessType.NONE)
//@XmlRootElement(name = "testing")

@Path("/test")
public class UserController {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	boolean activated = false;
	@Path("/{auth}")
	@GET
//	@RequestMapping(value = "/auth", method = RequestMethod.GET)
//	@GetMapping("")
//	@PermitAll
	public String auth()
	{
		LOG.info("Posting the auth key");
		activated = true;
		return "Paste this JSON payload for future POST/PUT requests. {\"app_name\": \"fast-r\", \"auth_key\": \"abc123\"}";
	}

//	@RequestMapping(value = "/post", method = RequestMethod.POST)
//	public ResponseEntity<HeaderModel> post_header (@Valid @RequestBody HeaderModel headerModel){
//		HeaderModel header2 = new HeaderModel();
//		header2.setApp_name(headerModel.getApp_name());
//		header2.setAuth_key(headerModel.getAuth_key());
//		return new ResponseEntity<HeaderModel>(header2, HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/put", method = RequestMethod.PUT)
//	public ResponseEntity<HeaderModel> put_header (@Valid @RequestBody HeaderModel headerModel){
//		HeaderModel header2 = new HeaderModel();
//		header2.setApp_name(headerModel.getApp_name());
//		header2.setAuth_key(headerModel.getAuth_key());
//		return new ResponseEntity<HeaderModel>(header2, HttpStatus.OK);

//	@PermitAll
	@Path("/{get}")
	@GET
//	@RequestMapping(value = "/get", method = RequestMethod.GET)
//	public String get() {
//		LOG.info("get mapping called");
//		return "sample get";
//	}
	public Response get()
	{
		String res = "sample get";
		System.out.println("GET RESPONSE");
		return Response.status(200).entity(res).build();
	}

//	@DenyAll
//	@RequestMapping(value = "/post", method = RequestMethod.POST)
	@Path("/{post}")
	@POST
	public String post()
	{
		LOG.info("post mapping called");
		return "dummy post";
	}

//	@DenyAll
//	@RequestMapping(value = "/put", method = RequestMethod.PUT)
	@Path("/{put}")
	@PUT
	public String put()
	{return "dummy put";
	}
}
