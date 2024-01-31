package com.maveric.kafka.serde;

import com.maveric.kafka.model.SubscriptionNotification;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

public class SubscriptionNotificationSerdes implements Serde<SubscriptionNotification> {
    @Override
    public Serializer<SubscriptionNotification> serializer() {
        return new JsonSerializer<>();
    }

    @Override
    public Deserializer<SubscriptionNotification> deserializer() {
        return new JsonDeserializer<>(SubscriptionNotification.class);
    }
}
