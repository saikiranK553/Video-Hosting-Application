package com.maveric.kafka.service;

import com.maveric.kafka.entity.MediaChannel;
import com.maveric.kafka.exception.MediaChannelAlreadyExistsException;
import com.maveric.kafka.exception.MediaChannelNotFoundException;
import com.maveric.kafka.model.MediaChannelRequestDTO;
import com.maveric.kafka.model.MediaChannelResponseDTO;
import com.maveric.kafka.repository.MediaChannelRepository;
import com.maveric.kafka.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MediaChannelServiceImpl implements MediaChannelService{
    private final MediaChannelRepository mediaChannelRepository;
    private final CommonUtils utils;

    @Override
    public MediaChannelResponseDTO saveMediaChannel(MediaChannelRequestDTO mediaChannelRequestDTO) {
        if(mediaChannelRepository.existsByName(mediaChannelRequestDTO.getName())){
            throw new MediaChannelAlreadyExistsException("Media channel is already exists with channel name"+mediaChannelRequestDTO.getName());
        }
        MediaChannel mediaChannel=utils.mediaChannelRequestDtoToMediaChannel(mediaChannelRequestDTO);
        mediaChannel.setCreatedDate(LocalDateTime.now());
        MediaChannel savedMediaChannel= mediaChannelRepository.save(mediaChannel);
        return utils.mediaChannelToMediaChannelResponseDTO(savedMediaChannel);
    }

    @Override
    public MediaChannelResponseDTO findByMediaChannelId(Long channelId) {
        Optional<MediaChannel> optionalMediaChannel= mediaChannelRepository.findById(channelId);
        if(!optionalMediaChannel.isPresent()){
            throw new MediaChannelNotFoundException("MediaChannel not found with channel Id "+channelId);
        }
        return utils.mediaChannelToMediaChannelResponseDTO(optionalMediaChannel.get());
    }
}
