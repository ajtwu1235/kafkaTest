package com.example.kafkaTest.kafka;

import com.example.kafkaTest.domain.kafka.Demo;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Ex2Producer {
    private final KafkaTemplate<String, Demo> template;

    public void send(Demo demo){
        template.send(TopicConfig.topic2,demo);
    }
}
