package com.maveric.kafka.serde;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.maveric.kafka.model.SubscriberInfo;
import com.maveric.kafka.model.VideoInfo;

import java.io.IOException;
import java.util.Set;

public class SubscriberJsonSerializer extends JsonSerializer<Set<SubscriberInfo>> {
    @Override
    public void serialize(Set<SubscriberInfo> subscriberInfos,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartArray();
        for (SubscriberInfo subscriberInfo : subscriberInfos) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeObjectField("subscriberInfo", subscriberInfo);
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
    }
}
