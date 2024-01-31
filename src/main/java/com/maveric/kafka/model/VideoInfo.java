package com.maveric.kafka.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VideoInfo {
    private Long id;
    private int widthResolution;
    private int heightResolution;
    private Long uploadedTo;
    private String name;
    private String title;
//    private LocalDateTime uploadDateTime;
    private Long viewsCount;
    private String description;
}
