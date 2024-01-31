package com.maveric.kafka.serde;

import com.maveric.kafka.model.NewVideosNotification;
import com.maveric.kafka.model.SubscriptionNotification;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

public class NewVideosSerde implements Serde<NewVideosNotification> {
    @Override
    public Serializer<NewVideosNotification> serializer() {
        return new JsonSerializer<>();
    }

    @Override
    public Deserializer<NewVideosNotification> deserializer() {
        return new JsonDeserializer<>(NewVideosNotification.class);
    }
}

