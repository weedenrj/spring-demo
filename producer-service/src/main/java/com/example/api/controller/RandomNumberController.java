package com.example.api.controller;

import java.util.concurrent.atomic.AtomicLong;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.RandomNumber;

@RestController
public class RandomNumberController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
  private final Random rand = new Random();

	@GetMapping("/random")
	public RandomNumber random(@RequestParam(value = "maxInt", defaultValue = "1000") int maxInt) {
		return new RandomNumber(counter.incrementAndGet(), rand.nextInt(maxInt));
	}
}
