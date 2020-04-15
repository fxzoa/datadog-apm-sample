package com.example.simple.common;

import java.net.Inet4Address;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author user
 */
@Component
@Slf4j
public class ServerConfig implements ApplicationListener<WebServerInitializedEvent> {

  private int serverPort;

  public int getPort() {
    return this.serverPort;
  }

  private String serverAddress;

  public String getAddress() {
    return this.serverAddress;
  }

  @Override
  public void onApplicationEvent(WebServerInitializedEvent event) {
    this.serverPort = event.getWebServer().getPort();
    log.info("Get WebServer port: {}", serverPort);

    this.serverAddress = "";
    try {
      this.serverAddress = Inet4Address.getLocalHost().getHostAddress();
    } catch (Exception e) {
      log.error(e.getMessage());
    }

    log.info("Get WebServer address: {}", serverAddress);
  }
}
