package com.maveric.kafka.serde;

import com.maveric.kafka.model.VideoInfo;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

public class VideoInfoSerdes implements Serde<VideoInfo> {

    @Override
    public Serializer<VideoInfo> serializer() {
        return new JsonSerializer<>();
    }

    @Override
    public Deserializer<VideoInfo> deserializer() {
        return new JsonDeserializer<>(VideoInfo.class);
    }
}
