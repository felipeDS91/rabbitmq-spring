package com.example.spring.consumer.amqp;

public interface AmqpConsumer<T> {
	
	void consumer(T t);

}
