package com.example.simple.page.controller;

import com.example.simple.common.ServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author user
 */
@Controller
@RequestMapping("/page")
public class PageController {

  @Autowired
  private ServerConfig serverConfig;

  @GetMapping("port")
  public String getPort(ModelMap map) {
    map.addAttribute("port",
        "URL:".concat(serverConfig.getAddress()).concat("/").concat(String.valueOf(serverConfig.getPort()))
    );
    return "port";
  }
}
