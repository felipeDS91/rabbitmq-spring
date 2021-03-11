package com.example.springproducer.service;

import com.example.springproducer.dto.MessageQueue;

public interface AmqpService {
	void sendToConsumer(MessageQueue message);
}
