package com.example.springproducer.ampq;

public interface AmqpProducer<T> {
	void producer(T t);
}
