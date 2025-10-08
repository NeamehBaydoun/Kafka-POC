package com.mdsl.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderConsumer {

    @KafkaListener(
            topicPartitions = @TopicPartition(
                    topic = "orders-poc", partitions = {"0"}),
            groupId = "orders-consumer-group")
    public void listen(ConsumerRecord<String, String> record) {
        System.out.println("📥 Consumed message from partition " + record.partition()
                + ": " + record.value());
    }

    @KafkaListener(
            topicPartitions = @TopicPartition(
                    topic = "orders-poc", partitions = {"1"}),
            groupId = "orders-consumer-group")
    public void listenV2(ConsumerRecord<String, String> record) {
        System.out.println("📥 Consumed message from partition " + record.partition()
                + ": " + record.value());
    }

    @KafkaListener(
            topicPartitions = @TopicPartition(
            topic = "orders-poc", partitions = {"2"}),
            groupId = "orders-consumer-group",
            containerFactory = "kafkaListenerContainerFactoryCustom" // use batch factory
    )
    public void listenBatch(List<String> messages) {
        System.out.println("📥 Consumed batch of " + messages.size() + " messages");
        for (String message : messages) {
            System.out.println(Thread.currentThread().getId() + ": "+message);
        }
    }
}
