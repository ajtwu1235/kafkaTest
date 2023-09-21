package com.example.kafkaTest.kafka;

import com.example.kafkaTest.domain.kafka.Demo;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class ConsumerConfig {
    private final KafkaProperties properties;

    @Bean
    public ConsumerFactory<String, Demo> consumerFactory
            (Map<String,Object> props){
//       try (JsonDeserialize<Demo> jsonDeserialize = new JsonDeserialize<>(Demo.class));



       JsonDeserializer<Demo> deserializer = new JsonDeserializer<>(Demo.class);
       deserializer.setRemoveTypeHeaders(false);
       deserializer.setUseTypeHeaders(true);
       deserializer.addTrustedPackages("*");
       return new DefaultKafkaConsumerFactory<>(
               props, new StringDeserializer(),deserializer
       );

    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,Demo> containerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, Demo> factory =
                new ConcurrentKafkaListenerContainerFactory<>();

        Map<String,Object> props = new HashMap<>(
                properties.buildConsumerProperties());
        factory.setConsumerFactory(consumerFactory(props));

        return factory;

    }
}
