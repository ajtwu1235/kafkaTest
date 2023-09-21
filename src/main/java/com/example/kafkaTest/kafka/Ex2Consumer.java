package com.example.kafkaTest.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Ex2Consumer {

    @KafkaListener(topics = TopicConfig.topic1,groupId = "groupId")
    public void listen(String msg){
        System.out.println("consumer :" +msg);
    }
}
