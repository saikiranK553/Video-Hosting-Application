package com.maveric.kafka.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
