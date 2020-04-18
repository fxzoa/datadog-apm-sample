package com.example.simple.common;

import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogInterceptor extends HandlerInterceptorAdapter {

  private static final Logger LOGGER = LoggerFactory.getLogger(LogInterceptor.class);

  private static final ThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("ThreadLocal StartTime");

  public LogInterceptor() {
    super();
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    long beginTime = System.currentTimeMillis();
    startTimeThreadLocal.set(beginTime);
    LOGGER.info("URI: {}; Start... ", request.getRequestURI(), new SimpleDateFormat("hh:mm:ss.SSS").format(beginTime));
    writeHttpHeaders(request);
    return true;
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
      @Nullable Exception ex) throws Exception {
    long beginTime = startTimeThreadLocal.get();
    long endTime = System.currentTimeMillis();
    LOGGER.info("URI: {}; End. Cost：{}ms", request.getRequestURI(), (endTime - beginTime));
  }
  
  private void writeHttpHeaders(HttpServletRequest request) {
	  LOGGER.info("# LogInterceptor HTTP Headers [BEGIN] #");
	  Enumeration headerNames = request.getHeaderNames();
	  while	(headerNames.hasMoreElements()) {
	    String key = (String) headerNames.nextElement();
	    LOGGER.info("# {} = {} ", key, request.getHeader(key));
	  }
	  LOGGER.info("# LogInterceptor HTTP Headers [END] #");
  }
  
}
