package com.maveric.kafka.service;

import com.maveric.kafka.model.VideoRequestDTO;
import com.maveric.kafka.model.VideoResponseDTO;

public interface VideoService {
    VideoResponseDTO saveVideo(VideoRequestDTO videoRequestDTO);
    String watchVideo(Long videoId);
}
