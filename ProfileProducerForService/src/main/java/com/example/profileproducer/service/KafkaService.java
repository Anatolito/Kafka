package com.example.profileproducer.service;

import com.example.profileproducer.dto.AbstractDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaService {

    private final KafkaTemplate<String, AbstractDTO> kafkaTemplate;

    @Value("${topic_profile}")
    private String TOPIC_PROFILE;

    public void send(AbstractDTO abstractDTO) {
        kafkaTemplate.send(TOPIC_PROFILE, abstractDTO);
    }

}
