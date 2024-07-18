package com.example.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

import com.example.api.model.RandomNumber;

@SpringBootApplication
public class ConsumerServiceApplication {

  private static final Logger log = LoggerFactory.getLogger(ConsumerServiceApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(ConsumerServiceApplication.class, args);
  }

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
  }

  @Bean
  @Profile("!test")
  public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
    return args -> {
      RandomNumber randNum = restTemplate.getForObject(
          "http://producer:8083/random", RandomNumber.class);
      log.info(randNum.toString());
    };
  }
}
