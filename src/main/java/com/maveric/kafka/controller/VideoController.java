package com.maveric.kafka.controller;

import com.maveric.kafka.model.VideoRequestDTO;
import com.maveric.kafka.model.VideoResponseDTO;
import com.maveric.kafka.service.VideoService;
import com.maveric.kafka.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/video")
@RequiredArgsConstructor
public class VideoController {
    private final VideoService videoService;
    private final CommonUtils utils;

    @PostMapping()
    public ResponseEntity<VideoResponseDTO> createVideo(@RequestBody VideoRequestDTO videoRequestDTO){
        VideoResponseDTO videoResponseDTO=videoService.saveVideo(videoRequestDTO);
        return ResponseEntity.ok().body(videoResponseDTO);
    }

    @GetMapping("/{videoId}")
    public ResponseEntity<String> watchingVideo(@PathVariable Long videoId){
        String message= videoService.watchVideo(videoId);
        return ResponseEntity.ok().body(message);
    }
}
