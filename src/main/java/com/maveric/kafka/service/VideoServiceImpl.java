package com.maveric.kafka.service;

import com.maveric.kafka.config.KafkaProcessor;
import com.maveric.kafka.entity.Video;
import com.maveric.kafka.exception.DuplicateVideoNameException;
import com.maveric.kafka.exception.MediaChannelNotFoundException;
import com.maveric.kafka.exception.VideoNotFoundException;
import com.maveric.kafka.model.VideoRequestDTO;
import com.maveric.kafka.model.VideoResponseDTO;
import com.maveric.kafka.repository.MediaChannelRepository;
import com.maveric.kafka.repository.VideoRepository;
import com.maveric.kafka.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService{
    private final VideoRepository videoRepository;
    private final MediaChannelRepository mediaChannelRepository;
    private final CommonUtils utils;
    private final KafkaProcessor processor;
    @Override
    public VideoResponseDTO saveVideo(VideoRequestDTO videoRequestDTO) {
        if(!mediaChannelRepository.existsById(videoRequestDTO.getUploadedTo())){
            throw new MediaChannelNotFoundException("no media channel found with the id "+videoRequestDTO.getUploadedTo()+" to upload the current video");
        }
        String videoName = videoRequestDTO.getName();
        if (videoRepository.existsByUploadedToAndName(videoRequestDTO.getUploadedTo(), videoName)) {
            throw new DuplicateVideoNameException("A video with the name '" + videoName + "' already exists in the channel "+videoRequestDTO.getUploadedTo());
        }
        Video video=utils.videoRequestDTOToVideo(videoRequestDTO);
        video.setUploadDateTime(LocalDateTime.now());
        Video savedVideo=videoRepository.save(video);
        processor.addVideoDetails(savedVideo);
        return utils.videoToVideoResponseDTO(savedVideo);
    }

    @Override
    public String watchVideo(Long videoId) {
        Optional<Video> optionalVideo=videoRepository.findById(videoId);
        if(!optionalVideo.isPresent()){
            throw new VideoNotFoundException("video not found with video Id : "+videoId);
        }
        processor.watchVideo(optionalVideo.get());
        return "watching video "+videoId+"!";
    }
}
