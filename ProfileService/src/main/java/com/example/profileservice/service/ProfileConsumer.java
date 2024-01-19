package com.example.profileservice.service;

import com.example.profileservice.dto.ProfileDTO;
import com.example.profileservice.util.ConverterDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.retrytopic.TopicSuffixingStrategy;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileConsumer {
    private static final String TOPIC_PROFILE = "${topic_profile}";
    private static final String GROUP_ID = "${group_id}";
    private final ConverterDto converterDto;
    private final ProfileServiceImpl profileService;

    @KafkaListener(topics = TOPIC_PROFILE, groupId = GROUP_ID)
    public void consumerProfile(String message) {
        ProfileDTO profileDTO = converterDto.convertToProfile(message);
        profileService.save(converterDto.fromDtoToProfile(profileDTO));
        log.info(profileDTO.toString());
    }

//    @RetryableTopic(
//            attempts = "3",
//            backoff = @Backoff(delay = 2000, multiplier = 5.0),
//            topicSuffixingStrategy = TopicSuffixingStrategy.SUFFIX_WITH_INDEX_VALUE)
//    @KafkaListener(topics = TOPIC_PROFILE, groupId = GROUP_ID)
//    public void listen(String in, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
//        log.warn(in + " from " + topic);
//        throw new RuntimeException("ERROR!!!!");
//    }

//    @DltHandler
//    public void dlt(String in, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
//        log.error(in + " from " + topic);
//    }
}
