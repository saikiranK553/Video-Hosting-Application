package com.maveric.kafka.controller;

import com.maveric.kafka.model.SubscribeChannelRequestDTO;
import com.maveric.kafka.model.SubscriberRequestDTO;
import com.maveric.kafka.model.SubscriberResponseDTO;
import com.maveric.kafka.service.SubscriberService;
import com.maveric.kafka.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subscriber")
@RequiredArgsConstructor
public class SubscriberController {
    private final SubscriberService subscriberService;
    private final CommonUtils utils;

    @PostMapping("/register")
    public ResponseEntity<SubscriberResponseDTO> createSubscriber(@RequestBody SubscriberRequestDTO subscriberRequestDTO){
        SubscriberResponseDTO subscriberResponseDTO=subscriberService.registerSubscriber(subscriberRequestDTO);
        return ResponseEntity.ok().body(subscriberResponseDTO);
    }

    @PostMapping("/subscribe")
    public ResponseEntity<String> subscribeToMediaChannel(@RequestBody SubscribeChannelRequestDTO subscribeChannelRequestDTO){
        String message=subscriberService.subscribeToChannel(subscribeChannelRequestDTO);
        return ResponseEntity.ok().body(message);
    }

}
