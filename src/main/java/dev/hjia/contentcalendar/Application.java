package dev.hjia.contentcalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
    // Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
  }

}
