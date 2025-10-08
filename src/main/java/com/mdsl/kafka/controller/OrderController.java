package com.mdsl.kafka.controller;

import com.mdsl.kafka.producer.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderProducer producer;

    @PostMapping("/{orderId}")
    public String publishOrder(@PathVariable String orderId){
        Integer orderIdInt =Integer.parseInt(orderId);
        if (orderIdInt% 2 == 0) {
            producer.sendOrderV2(String.valueOf(orderIdInt));
        } else {
            producer.sendOrderV3(String.valueOf(orderIdInt));
        }
        return "Order " + orderId + " sent to Kafka!";
    }
}