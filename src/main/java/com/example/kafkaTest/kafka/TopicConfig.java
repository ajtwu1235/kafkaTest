package com.example.kafkaTest.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {
    public final static String topic1 ="ex1";
    public final static String topic2 ="ex2";

    @Bean
    public NewTopic topic1(){
        return new NewTopic(topic1,1, (short) 1);

    }

    @Bean
    public NewTopic topic2(){
        return TopicBuilder.name(topic2)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
