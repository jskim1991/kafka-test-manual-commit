package io.jjstudio.Kafkatest.config;

import org.springframework.cloud.stream.config.ListenerContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;

@Configuration
public class KafkaConfiguration {

    @Bean
    public ListenerContainerCustomizer<ConcurrentMessageListenerContainer<?, ?>> cust() {
        return (container, destination, group) ->
                container.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
    }
}
