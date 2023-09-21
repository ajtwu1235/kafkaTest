package com.example.kafkaTest;


import com.example.kafkaTest.DemoService;
import com.example.kafkaTest.domain.request.DemoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DemoController {
    private final DemoService demoService;

    @GetMapping("{msg}")
    public void test(@PathVariable String msg){
        demoService.sendStringMsg(msg);
    }

    @PostMapping
    public void ex2Test(@RequestBody DemoRequest request){

        demoService.save(request);
    }
}
