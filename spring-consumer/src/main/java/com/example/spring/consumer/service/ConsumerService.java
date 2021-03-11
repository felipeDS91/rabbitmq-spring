package com.example.spring.consumer.service;

import com.example.spring.consumer.dto.MessageQueue;

public interface ConsumerService {
	
	void action(MessageQueue message);
	
}
