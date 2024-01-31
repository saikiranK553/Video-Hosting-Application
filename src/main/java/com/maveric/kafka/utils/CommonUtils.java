package com.maveric.kafka.utils;

import com.maveric.kafka.entity.MediaChannel;
import com.maveric.kafka.entity.Subscriber;
import com.maveric.kafka.entity.Video;
import com.maveric.kafka.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CommonUtils {
    public MediaChannelResponseDTO mediaChannelToMediaChannelResponseDTO(MediaChannel mediaChannel){
        MediaChannelResponseDTO mediaChannelResponseDTO=new MediaChannelResponseDTO();
        BeanUtils.copyProperties(mediaChannel,mediaChannelResponseDTO);
        return mediaChannelResponseDTO;
    }

    public MediaChannel mediaChannelRequestDtoToMediaChannel(MediaChannelRequestDTO mediaChannelRequestDTO){
        MediaChannel mediaChannel=new MediaChannel();
        BeanUtils.copyProperties(mediaChannelRequestDTO,mediaChannel);
        return mediaChannel;
    }

    public VideoResponseDTO videoToVideoResponseDTO(Video video){
        VideoResponseDTO videoResponseDTO=new VideoResponseDTO();
        BeanUtils.copyProperties(video,videoResponseDTO);
        return videoResponseDTO;
    }

    public Video videoRequestDTOToVideo(VideoRequestDTO videoRequestDTO){
        Video video=new Video();
        BeanUtils.copyProperties(videoRequestDTO,video);
        return video;
    }

    public SubscriberResponseDTO subscriberToSubscriberResponseDTO(Subscriber subscriber){
        SubscriberResponseDTO subscriberResponseDTO=new SubscriberResponseDTO();
        BeanUtils.copyProperties(subscriber,subscriberResponseDTO);
        return subscriberResponseDTO;
    }

    public Subscriber subscriberRequestDtoToSubscriber(SubscriberRequestDTO subscriberRequestDTO){
        Subscriber subscriber=new Subscriber();
        BeanUtils.copyProperties(subscriberRequestDTO,subscriber);
        return subscriber;
    }
}
