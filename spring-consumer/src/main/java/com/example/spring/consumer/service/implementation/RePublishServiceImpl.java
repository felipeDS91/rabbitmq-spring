package com.example.spring.consumer.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.consumer.amqp.AmqpRePublish;
import com.example.spring.consumer.service.RePublishService;

@Service
public class RePublishServiceImpl implements RePublishService{

	@Autowired
	private AmqpRePublish republish;
	
	@Override
	public void repost() {
		republish.rePublish();		
	}	
}
