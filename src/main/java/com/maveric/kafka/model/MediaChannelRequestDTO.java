package com.maveric.kafka.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MediaChannelRequestDTO {
    private String name;
    private String createdBy;
}
