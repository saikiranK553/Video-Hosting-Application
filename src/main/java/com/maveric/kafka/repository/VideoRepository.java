package com.maveric.kafka.repository;

import com.maveric.kafka.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video,Long> {
    boolean existsByUploadedToAndName(Long uploadedTo, String name);
}
