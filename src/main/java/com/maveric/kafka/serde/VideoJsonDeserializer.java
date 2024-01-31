package com.maveric.kafka.serde;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.maveric.kafka.model.VideoInfo;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class VideoJsonDeserializer extends JsonDeserializer<Set<VideoInfo>> {

    @Override
    public Set<VideoInfo> deserialize(JsonParser jsonParser,
                                      DeserializationContext deserializationContext) throws IOException, JacksonException {
        Set<VideoInfo> videoInfos = new HashSet<>();
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        Long id = (Long) ((IntNode) node.get("id")).longValue();
        String name = node.get("name").asText();
        // Parse 'widthResolution' property
        int widthResolution = node.get("widthResolution").asInt();
        int heightResolution = node.get("heightResolution").asInt();
        Long uploadedTo = node.get("uploadedTo").asLong();
        String title = node.get("title").asText();
        Long viewsCount = node.get("viewsCount").asLong();
        String description = node.get("description").asText();
        videoInfos.add(VideoInfo.builder()
                .id(id)
                        .widthResolution(widthResolution)
                        .heightResolution(heightResolution)
                .name(name)
                                .uploadedTo(uploadedTo)
                                .title(title)
                                .viewsCount(viewsCount)
                                .description(description)
                .build());
        return videoInfos;
    }


}
