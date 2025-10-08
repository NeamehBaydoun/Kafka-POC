package com.mdsl.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(String orderId) {
        String topic = "orders-poc";
        String message = "New order received: " + orderId;
        kafkaTemplate.send(topic,0, orderId, message);
    }

    public void sendOrderV2(String orderId) {
        String topic = "orders-poc";
        String message = "New order received: " + orderId;
        kafkaTemplate.send(topic,1, orderId, message);
        System.out.println("📤 Sent order " + orderId + " to partition 1");
    }

    public void sendOrderV3(String orderId)  {
        String topic = "orders-poc";
        String message = "New order received: " + orderId;
        kafkaTemplate.send(topic,2, orderId, message);
        System.out.println(Thread.currentThread().getName() + ": 📤 Sent order " + orderId + " to partition 2");
    }
}