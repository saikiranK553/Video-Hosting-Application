package com.maveric.kafka.model;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class VideoResponseDTO {
    private Long id;
    private int widthResolution;
    private int heightResolution;
    private Long uploadedTo;
    private String name;
    private String title;
    private LocalDateTime uploadDateTime;
    private Long viewsCount;
    private String description;
}
