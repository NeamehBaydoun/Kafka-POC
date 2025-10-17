package com.mdsl.kafka.producer;

import com.mdsl.kafka.dtos.KafkaDtoMessageRequestDTO;
import com.mdsl.kafka.dtos.KafkaStringMessageRequestDTO;
import com.mdsl.kafka.dtos.MessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String, String> stringKafkaTemplate;

    private final KafkaTemplate<String, MessageDTO> dtoKafkaTemplate;

    public void sendStringMessage(KafkaStringMessageRequestDTO message) {
        stringKafkaTemplate.send(message.getTopic(),message.getPartition(), null, message.getMessage());
    }

    public void sendDtoMessage(KafkaDtoMessageRequestDTO message) {
        dtoKafkaTemplate.send(message.getTopic(),message.getPartition(), null, message.getMessageDTO());
    }
}