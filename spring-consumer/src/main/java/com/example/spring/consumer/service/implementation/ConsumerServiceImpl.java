package com.example.spring.consumer.service.implementation;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.stereotype.Service;

import com.example.spring.consumer.dto.MessageQueue;
import com.example.spring.consumer.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService{

	@Override
	public void action(MessageQueue message) {
		if ("teste".equalsIgnoreCase(message.getText())) {
			throw new AmqpRejectAndDontRequeueException("erro");
		}
		
		System.out.print(message.getText());	
	}

}
