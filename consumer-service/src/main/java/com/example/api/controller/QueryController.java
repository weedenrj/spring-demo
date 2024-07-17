package com.example.api.controller;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.api.model.RandomNumber;

@RestController
public class QueryController {

  @GetMapping("/")
  public RandomNumber home() {
    RestTemplate restTemplate = new RestTemplate();

    String uri = "http://localhost:8083";

    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    headers.add("user-agent",
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

    HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
    ResponseEntity<?> result = restTemplate.exchange(uri, HttpMethod.GET, entity, RandomNumber.class);
    return (RandomNumber) result.getBody();
  }
}
