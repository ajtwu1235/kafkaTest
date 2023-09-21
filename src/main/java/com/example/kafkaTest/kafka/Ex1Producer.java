package com.example.kafkaTest.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
public class Ex1Producer {

    private final KafkaTemplate<String,String> kafkaTemplate;

    @Async
    public void send(String msg){
        CompletableFuture<SendResult<String, String>> future =
                kafkaTemplate.send(TopicConfig.topic1, msg);

        //axios와 유사
        future.thenAccept(result->
                System.out.println("send After"+msg+""+result.getRecordMetadata().offset()));
    }

}
