package com.example.kafkaTest.domain.request;

import com.example.kafkaTest.domain.kafka.Demo;

import java.util.UUID;

public record DemoRequest(String name , String desc){
    public Demo toKafka(){
        return new Demo(UUID.randomUUID(),name,desc);
    }
}
