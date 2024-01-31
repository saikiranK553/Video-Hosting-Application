package com.maveric.kafka.model;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MediaChannelResponseDTO {
    private Long id;
    private String name;
    private String createdBy;
    private LocalDateTime createdDate;
}
