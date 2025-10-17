package com.mdsl.kafka.controller;

import com.mdsl.kafka.dtos.KafkaDtoMessageRequestDTO;
import com.mdsl.kafka.dtos.KafkaStringMessageRequestDTO;
import com.mdsl.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
public class ProducerController {

    private final KafkaProducer producer;

    @PostMapping("/string")
    public void sendStringMessage(@RequestBody KafkaStringMessageRequestDTO message){
        producer.sendStringMessage(message);
    }

    @PostMapping("/dto")
    public void sendDtoMessage(@RequestBody KafkaDtoMessageRequestDTO message){
        producer.sendDtoMessage(message);
    }
}