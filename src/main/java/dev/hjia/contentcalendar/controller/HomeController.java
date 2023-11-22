package dev.hjia.contentcalendar.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hjia.contentcalendar.config.ContentCalendarProperties;

@RestController
public class HomeController {

  private final ContentCalendarProperties properties;

  public HomeController(ContentCalendarProperties properties) {
    this.properties = properties;
  }

  @Value("${cc.welcomeMessage: Default Welcome Message👌👏}")
  private String welcomeMessage;

  @Value("${cc.about}")
  private String about;

  @GetMapping
  public ContentCalendarProperties home() {
    return properties;
  }
}
