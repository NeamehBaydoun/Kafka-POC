package com.mdsl.kafka.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KafkaDtoMessageRequestDTO {
    private MessageDTO messageDTO;
    private int partition;
    private String topic;
    private String groupId;
}
