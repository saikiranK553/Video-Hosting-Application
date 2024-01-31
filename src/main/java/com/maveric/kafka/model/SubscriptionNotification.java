package com.maveric.kafka.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionNotification {
    private Long channelId;
    private String channelOwnerEmail;
    @JsonIgnore
    private Set<SubscriberInfo> subscriberInfoList = new HashSet<>();
}
