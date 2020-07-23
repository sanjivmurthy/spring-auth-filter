package com.baeldung.bootcustomfilters.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Boot application
 * @author hemant
 *
 */
@SpringBootApplication
public class SpringBootFiltersApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFiltersApplication.class, args);
	}
}
