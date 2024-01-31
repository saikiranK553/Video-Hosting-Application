package com.maveric.kafka.config;

import com.maveric.kafka.entity.Subscriber;
import com.maveric.kafka.entity.Video;
import com.maveric.kafka.model.SubscriberInfo;
import com.maveric.kafka.model.VideoInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProcessor {
    private final StreamBridge streamBridge;

    public void addVideoDetails(Video video){
        VideoInfo videoInfo=VideoInfo.builder()
                .id(video.getId())
                .widthResolution(video.getWidthResolution())
                .heightResolution(video.getHeightResolution())
                .name(video.getName())
                .uploadedTo(video.getUploadedTo())
                .title(video.getTitle())
                .viewsCount(video.getViewsCount())
                .description(video.getDescription())
                .build();
        Message<VideoInfo> message= MessageBuilder.withPayload(videoInfo)
                .setHeader(KafkaHeaders.KEY,video.getId())
                .build();
        streamBridge.send(Constants.VIDEO_CREATED,message);
    }

    public void watchVideo(Video video){
        Message<String> message=MessageBuilder.withPayload(video.getName())
                .setHeader(KafkaHeaders.KEY,video.getId())
                .build();
        //streamBridge.send("view-out-0",message);
        streamBridge.send(Constants.WATCHING_VIDEO,message);
    }

    public void addSubscriberDetails(Long channelId, Subscriber subscriber){
        SubscriberInfo subscriberInfo=SubscriberInfo.builder()
                .id(subscriber.getId())
                .firstName(subscriber.getFirstName())
                .lastName(subscriber.getLastName())
                .email(subscriber.getEmail())
                .build();
        Message<SubscriberInfo> message=MessageBuilder.withPayload(subscriberInfo)
                .setHeader(KafkaHeaders.KEY,channelId)
                .build();
//        streamBridge.send("subscription-out-0",message);
        streamBridge.send(Constants.SUBSCRIBER_CREATED,message);

    }
}
