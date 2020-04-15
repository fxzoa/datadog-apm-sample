package com.example.simple.api.controller;

import com.example.simple.common.ServerConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author user
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class HelloController {

  @Autowired
  private ServerConfig serverConfig;

  @GetMapping("port")
  public String getPort() {

    String returnValue = "URL:";
    returnValue = returnValue.concat(serverConfig.getAddress());
    returnValue = returnValue.concat("/");
    returnValue = returnValue.concat(String.valueOf(serverConfig.getPort()));
    return returnValue;
  }

  @GetMapping("hello")
  public String get() {
    return "hello";
  }

}
