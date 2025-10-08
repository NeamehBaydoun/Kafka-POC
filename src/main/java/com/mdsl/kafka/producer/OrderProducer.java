package com.mdsl.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendOrder(String orderId) {
        String topic = "orders-poc";
        String message = "New order received: " + orderId;
        kafkaTemplate.send(topic,0, orderId, message);
    }

    public void sendOrderV2(String orderId) {
        String topic = "orders-poc";
        String message = "New order received: " + orderId;
        kafkaTemplate.send(topic,1, orderId, message);
        log.debug("Sent order {} to partition 1", orderId);
    }

    public void sendOrderV3(String orderId)  {
        String topic = "orders-poc";
        String message = "New order received: " + orderId;
        kafkaTemplate.send(topic,2, orderId, message);
        log.debug("{}: Sent order {} to partition 2", Thread.currentThread().getName(), orderId);
    }
}