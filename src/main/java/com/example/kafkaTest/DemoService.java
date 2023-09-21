package com.example.kafkaTest;

import com.example.kafkaTest.domain.request.DemoRequest;
import com.example.kafkaTest.kafka.Ex1Producer;
import com.example.kafkaTest.kafka.Ex2Producer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DemoService {

    private  final Ex1Producer ex1Producer;
    private final Ex2Producer ex2Producer;

    public void sendStringMsg(String msg){
        ex1Producer.send(msg);
        log.info(msg);
    }

    public void save(DemoRequest request){
      ex2Producer.send(request.toKafka());
    }

}
