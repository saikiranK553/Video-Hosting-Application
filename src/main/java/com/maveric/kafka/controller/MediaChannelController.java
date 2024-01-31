package com.maveric.kafka.controller;

import com.maveric.kafka.model.MediaChannelRequestDTO;
import com.maveric.kafka.model.MediaChannelResponseDTO;
import com.maveric.kafka.service.MediaChannelService;
import com.maveric.kafka.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mediaChannel")
@RequiredArgsConstructor
public class MediaChannelController {
    private final MediaChannelService mediaChannelService;
    private final CommonUtils utils;

    @PostMapping()
    public ResponseEntity<MediaChannelResponseDTO> createMediaChannel(@RequestBody MediaChannelRequestDTO mediaChannelRequestDTO){
        MediaChannelResponseDTO mediaChannelResponseDTO=mediaChannelService.saveMediaChannel(mediaChannelRequestDTO);
        return ResponseEntity.ok().body(mediaChannelResponseDTO);
    }

    @GetMapping("/{channelId}")
    public ResponseEntity<MediaChannelResponseDTO> fetchMediaChannelById(@PathVariable Long channelId){
        MediaChannelResponseDTO mediaChannelResponseDTO=mediaChannelService.findByMediaChannelId(channelId);
        return ResponseEntity.ok().body(mediaChannelResponseDTO);
    }
}
