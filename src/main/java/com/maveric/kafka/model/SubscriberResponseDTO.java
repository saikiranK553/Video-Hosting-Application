package com.maveric.kafka.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubscriberResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
