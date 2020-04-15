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

import org.springframework.stereotype.Component;

@Component
public class LoggingFilter implements Filter {
	
	   @Override
	    public void init(FilterConfig filterConfig) throws ServletException {
	        System.out.println("### LoggingFilter#init() ###");
	    }

	    @Override
	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    	writeHttpHeaders((HttpServletRequest) request);
	    }
	    
	    private void writeHttpHeaders(HttpServletRequest request) {
	    	System.out.println("### LoggingFilter HTTP Headers [BEGIN] ### ");
	  	  	Enumeration headerNames = request.getHeaderNames();
	  	  	while	(headerNames.hasMoreElements()) {
	  	  		String key = (String) headerNames.nextElement();
	  	  		System.out.println("### " + key + " = " + request.getHeader(key));
	  	  	}
	  	  	System.out.println("### LoggingFilter HTTP Headers [END] ### ");
	    }
	    
}
