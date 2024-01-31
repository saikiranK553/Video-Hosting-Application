package com.maveric.kafka.serde;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.charset.StandardCharsets;

public class JsonDeserializer<T> implements Deserializer<T> {

    private Class<T> destinationClass;

    public JsonDeserializer(Class<T> destinationClass) {
        this.destinationClass = destinationClass;
    }

    @Override
    public T deserialize(String topic, byte[] bytes) {
        if (bytes == null)
            return null;

        try {
            String text= new String(bytes, StandardCharsets.UTF_8);
            return JsonMapper.readFromJson(text, destinationClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
