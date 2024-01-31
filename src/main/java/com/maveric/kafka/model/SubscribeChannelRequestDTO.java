package com.maveric.kafka.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubscribeChannelRequestDTO {
    private String email;
    private Long channelId;
}
