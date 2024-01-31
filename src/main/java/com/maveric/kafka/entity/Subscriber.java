package com.maveric.kafka.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscriber_id")
    private Long id;
    private String firstName;
    private String lastName;
//    @OneToMany
    @ManyToMany
////    @JoinColumn(name="subscribedTo")
    @JoinTable(
            name = "channel_subscribe",
            joinColumns = @JoinColumn(name = "subscriber_id", referencedColumnName = "subscriber_id"),
            inverseJoinColumns = @JoinColumn(name = "channel_id", referencedColumnName = "channel_id")
    )
    private Set<MediaChannel> subscribedTo;
    private String email;
}
