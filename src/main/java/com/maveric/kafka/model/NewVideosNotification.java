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
public class NewVideosNotification {
    @JsonIgnore
    private Set<SubscriberInfo> subscriberInfoList = new HashSet<>();
    private Set<VideoInfo> videos;
}
