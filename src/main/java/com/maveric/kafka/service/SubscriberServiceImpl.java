package com.maveric.kafka.service;

import com.maveric.kafka.config.KafkaProcessor;
import com.maveric.kafka.entity.MediaChannel;
import com.maveric.kafka.entity.Subscriber;
import com.maveric.kafka.exception.AlreadySubscribedtoChannelException;
import com.maveric.kafka.exception.EmailAlreadyExistsException;
import com.maveric.kafka.exception.MediaChannelNotFoundException;
import com.maveric.kafka.exception.SubscriberNotFoundException;
import com.maveric.kafka.model.SubscribeChannelRequestDTO;
import com.maveric.kafka.model.SubscriberRequestDTO;
import com.maveric.kafka.model.SubscriberResponseDTO;
import com.maveric.kafka.repository.MediaChannelRepository;
import com.maveric.kafka.repository.SubscriberRepository;
import com.maveric.kafka.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubscriberServiceImpl implements SubscriberService{
    private final SubscriberRepository subscriberRepository;
    private final CommonUtils utils;
    private final MediaChannelRepository mediaChannelRepository;
    private final KafkaProcessor processor;
    @Override
    public SubscriberResponseDTO registerSubscriber(SubscriberRequestDTO subscriberRequestDTO) {
        if(subscriberRepository.existsByEmail(subscriberRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException("Email is already registered!");
        }
        Subscriber subscriber=utils.subscriberRequestDtoToSubscriber(subscriberRequestDTO);
        Subscriber savedSubscriber= subscriberRepository.save(subscriber);
        return utils.subscriberToSubscriberResponseDTO(savedSubscriber);
    }

    @Override
    public String subscribeToChannel(SubscribeChannelRequestDTO subscribeChannelRequestDTO) {
        Optional<Subscriber> optionalSubscriber=subscriberRepository.findByEmail(subscribeChannelRequestDTO.getEmail());
        Optional<MediaChannel> optionalMediaChannel=mediaChannelRepository.findById(subscribeChannelRequestDTO.getChannelId());
        if(!optionalMediaChannel.isPresent()){
            throw new MediaChannelNotFoundException("Media channel not found with channel Id "+subscribeChannelRequestDTO.getChannelId());
        }
        if(!optionalSubscriber.isPresent()){
            throw new SubscriberNotFoundException("No subscriber with given email");
        }
        Subscriber subscriber=optionalSubscriber.get();
        if(subscriber.getSubscribedTo().contains(optionalMediaChannel.get())){
            throw new AlreadySubscribedtoChannelException("this channel has already been subscribed");
        }
        subscriber.getSubscribedTo().add(optionalMediaChannel.get());
        Subscriber savedSubscriber= subscriberRepository.save(subscriber);
        processor.addSubscriberDetails(subscribeChannelRequestDTO.getChannelId(),savedSubscriber);
        return "Successfully Subscribed to channel "+subscribeChannelRequestDTO.getChannelId();
    }
}
