package com.maveric.kafka.repository;

import com.maveric.kafka.entity.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscriberRepository extends JpaRepository<Subscriber,Long> {
    boolean existsByEmail(String email);
    Optional<Subscriber> findByEmail(String email);
}
