package com.maveric.kafka.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubscriberRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
}
