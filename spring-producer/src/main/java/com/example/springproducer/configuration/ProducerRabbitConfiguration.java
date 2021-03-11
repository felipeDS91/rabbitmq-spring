package com.example.springproducer.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerRabbitConfiguration {
	
	@Value("${spring.rabbitmq.request.routing-key.producer}")
	private String queue;
	
	@Value("${spring.rabbitmq.request.exchange.producer}")
	private String exchange;
	
	@Value("${spring.rabbitmq.request.dead-letter.producer}")
	private String deadLetter;

	@Value("${spring.rabbitmq.request.parking-lot.producer}")
	private String parkingLot;	
	
	@Bean
	DirectExchange exchange() {
		return new DirectExchange(exchange);
	}
	
	@Bean
	Queue deadLetter() {
		return QueueBuilder.durable(deadLetter)
				.deadLetterExchange(exchange)
				.deadLetterRoutingKey(queue)
				.build();			
	}
	
	@Bean
	Queue queue() {
		return QueueBuilder.durable(queue)
				.deadLetterExchange(exchange)
				.deadLetterRoutingKey(deadLetter)
				.build();
	}

	@Bean
	Queue parkingLot() {
		return new Queue(parkingLot);
	}
	
	@Bean
	public Binding bindingQueue() {
		return BindingBuilder.bind(queue())
				.to(exchange()).with(queue);						
	}
	
	@Bean
	public Binding bindingDeadLetter() {
		return BindingBuilder.bind(deadLetter())
				.to(exchange()).with(deadLetter);
	}
	
	@Bean
	public Binding bindingParkingLote() {
		return BindingBuilder.bind(parkingLot()).to(exchange()).with(parkingLot);
	}
}
