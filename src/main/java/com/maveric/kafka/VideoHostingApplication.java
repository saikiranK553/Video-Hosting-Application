package com.maveric.kafka;

import com.maveric.kafka.config.Constants;
import com.maveric.kafka.model.NewVideosNotification;
import com.maveric.kafka.model.SubscriberInfo;
import com.maveric.kafka.model.SubscriptionNotification;
import com.maveric.kafka.model.VideoInfo;
import com.maveric.kafka.serde.*;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.Duration;
import java.util.function.Function;

@SpringBootApplication
@OpenAPIDefinition(info =
@Info(title = Constants.SWAGGER_TITLE, version = Constants.SWAGGER_VERSION, description = Constants.SWAGGER_DESCRIPTION)
)

@Slf4j
public class VideoHostingApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoHostingApplication.class, args);
    }

    @Bean
    public Serde<Long> longSerde() {
        return Serdes.Long();
    }

    @Bean
    public Serde<VideoInfo> videoInfoSerde() {
        return new VideoInfoSerdes();
    }

    @Bean
    public Serde<SubscriberInfo> subscriberInfoSerde() {
        return new SubscriberInfoSerdes();
    }

    @Bean
    public Serde<SubscriptionNotification> subscriptionNotificationSerde() {
        return new SubscriptionNotificationSerdes();
    }

    @Bean
    public Serde<NewVideosNotification> newVideosNotificationSerde() {
        return new NewVideosSerde();
    }


    @Bean
    public Function<KStream<Long, String>, KStream<Long, Long>> viewsCountByKeyInWindow() {
        KeyValueMapper<Windowed<Long>, Long, KeyValue<Long, Long>> keyValueMap = (windowKey, value) -> new KeyValue<>(windowKey.key(), value);

        Function<KStream<Long, String>, KStream<Long, Long>> function = inputStream ->
                inputStream
                        .groupByKey()
                        .windowedBy(TimeWindows.ofSizeWithNoGrace(Duration.ofMinutes(5)))
                        .count()
                        .toStream()
                        .map(keyValueMap)
                        .peek((key, value) -> System.out.println(" windowed for 5min key=" + key + " value=" + value));
        return function;
    }


}
