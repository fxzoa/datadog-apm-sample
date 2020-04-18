package com.example.simple.common;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RequestLoggingFilter implements Filter {

	   @Override
	    public void init(FilterConfig filterConfig) throws ServletException {
	        log.info("### RequestLoggingFilter#init() ###");
	    }

	    @Override
	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    	writeHttpHeaders((HttpServletRequest) request);
	    	chain.doFilter(request, response);
	    	log.info("# HTTP Request Compleate. #");
	    }

	    private void writeHttpHeaders(HttpServletRequest request) {
			log.info(" ");
	    	log.info("# Http Request Path: {} #", request.getPathInfo());
	    	log.info("# Http Request Headers [BEGIN] #");
	  	  	Enumeration headerNames = request.getHeaderNames();
	  	  	while	(headerNames.hasMoreElements()) {
	  	  		String key = (String) headerNames.nextElement();
	  	  		log.info("# {} = {}", key, request.getHeader(key));
	  	  	}
	  	  	log.info("#Http Request Headers [END] #");
			log.info(" ");
	    }

}
