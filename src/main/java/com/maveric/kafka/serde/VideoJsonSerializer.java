package com.maveric.kafka.serde;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.maveric.kafka.model.VideoInfo;

import java.io.IOException;
import java.util.Set;

public class VideoJsonSerializer extends JsonSerializer<Set<VideoInfo>> {
    @Override
    public void serialize(Set<VideoInfo> videoInfos,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartArray();
        for(VideoInfo videoInfo: videoInfos) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeObjectField("videoInfo", videoInfo);
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
    }
}
