package com.maveric.kafka.model;

import lombok.*;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VideoRequestDTO {
    private int widthResolution;
    private int heightResolution;
    private Long uploadedTo;
    private String name;
    private String title;
    private Long viewsCount;
    private String description;
}
