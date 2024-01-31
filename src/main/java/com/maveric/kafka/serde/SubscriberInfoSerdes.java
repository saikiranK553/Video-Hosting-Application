package com.maveric.kafka.serde;

import com.maveric.kafka.model.SubscriberInfo;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

public class SubscriberInfoSerdes implements Serde<SubscriberInfo> {
    @Override
    public Serializer<SubscriberInfo> serializer() {
        return new JsonSerializer<>();
    }

    @Override
    public Deserializer<SubscriberInfo> deserializer() {
        return new JsonDeserializer<>(SubscriberInfo.class);
    }
}
