package com.baeldung.bootcustomfilters.controller;

import com.baeldung.bootcustomfilters.model.HeaderModel;
import com.baeldung.bootcustomfilters.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Rest controller for User
 * @author hemant
 *
 */
@RestController

public class UserController {

	boolean activated = false;
	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	@GetMapping("")
	public String auth(){
		LOG.info("Posting the auth key");
		activated = true;
		return "Paste this JSON payload for future POST/PUT requests. {\"app_name\": \"fast-r\", \"auth_key\": \"abc123\"}";}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public ResponseEntity<HeaderModel> post_header (@Valid @RequestBody HeaderModel headerModel){
		HeaderModel header2 = new HeaderModel();
		header2.setApp_name(headerModel.getApp_name());
		header2.setAuth_key(headerModel.getAuth_key());
		return new ResponseEntity<HeaderModel>(header2, HttpStatus.OK);

	}

	@RequestMapping(value = "/put", method = RequestMethod.PUT)
	public ResponseEntity<HeaderModel> put_header (@Valid @RequestBody HeaderModel headerModel){
		HeaderModel header2 = new HeaderModel();
		header2.setApp_name(headerModel.getApp_name());
		header2.setAuth_key(headerModel.getAuth_key());
		return new ResponseEntity<HeaderModel>(header2, HttpStatus.OK);
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String get() {return "sample get";}
}
