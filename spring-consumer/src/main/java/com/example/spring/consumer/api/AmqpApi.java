package com.example.spring.consumer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.consumer.service.RePublishService;

@RestController
public class AmqpApi {
	
	@Autowired
	private RePublishService service;
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@GetMapping("/repost")
	public void sendToQueue() {
		service.repost();
	}
	
}
