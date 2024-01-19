package com.example.profileproducer.controller;

import com.example.profileproducer.dto.ProfileDTO;
import com.example.profileproducer.service.KafkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProducerController {

    private final KafkaService kafkaService;

    @PostMapping("/sendProfile")
    public ResponseEntity<String> sendMessage(@RequestBody ProfileDTO profileDTO){
        kafkaService.send(profileDTO);
        return new ResponseEntity<>("Profile send", HttpStatus.OK);
    }
}
