package com.maveric.kafka.service;

import com.maveric.kafka.model.MediaChannelRequestDTO;
import com.maveric.kafka.model.MediaChannelResponseDTO;

public interface MediaChannelService {
    MediaChannelResponseDTO saveMediaChannel(MediaChannelRequestDTO mediaChannelRequestDTO);
    MediaChannelResponseDTO findByMediaChannelId(Long channelId);
}
