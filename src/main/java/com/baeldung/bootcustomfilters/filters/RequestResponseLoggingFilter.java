//package com.baeldung.bootcustomfilters.filters;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * A servlet filter to log request and response
// * The logging implementation is pretty native and for demonstration only
// * @author hemant
// *
// */
////@Component
////@Order(2)
//public class RequestResponseLoggingFilter implements Filter {
//
//	private final static Logger LOG = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);
//
//	@Override
//	public void init(final FilterConfig filterConfig) throws ServletException {
//		LOG.info("Initializing filter :{}", this);
//	}
//
//	@Override
//	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
//			throws IOException, ServletException {
//		HttpServletRequest req = (HttpServletRequest) request;
//		HttpServletResponse res = (HttpServletResponse) response;
//
//
//		System.out.println("request: " + req.toString());
//		System.out.println("response: " + res.toString());
//
//
//		LOG.info("Logging Request  {} : {}", req.getMethod(), req.getRequestURI());
//		chain.doFilter(request, response);
//		LOG.info("Logging Response :{}", res.getHeaderNames());
//	}
//
//	@Override
//	public void destroy() {
//		LOG.warn("Destructing filter :{}", this);
//	}
//
//
//	@Bean
//	public FilterRegistrationBean<RequestResponseLoggingFilter> loggingFilter(){
//		FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean = new FilterRegistrationBean<>();
//
//		registrationBean.setFilter(new RequestResponseLoggingFilter());
//		registrationBean.addUrlPatterns("/post/*");
//
//		return registrationBean;
//	}
//}
