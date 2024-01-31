package com.maveric.kafka.repository;

import com.maveric.kafka.entity.MediaChannel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaChannelRepository extends JpaRepository<MediaChannel,Long> {
    boolean existsByName(String channelName);
}
