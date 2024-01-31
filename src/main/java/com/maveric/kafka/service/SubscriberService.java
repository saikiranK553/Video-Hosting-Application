package com.maveric.kafka.service;

import com.maveric.kafka.model.SubscribeChannelRequestDTO;
import com.maveric.kafka.model.SubscriberRequestDTO;
import com.maveric.kafka.model.SubscriberResponseDTO;

public interface SubscriberService {
    SubscriberResponseDTO registerSubscriber(SubscriberRequestDTO subscriberRequestDTO);
    String subscribeToChannel(SubscribeChannelRequestDTO subscribeChannelRequestDTO);
}
