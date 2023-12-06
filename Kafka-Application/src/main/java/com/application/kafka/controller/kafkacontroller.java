package com.application.kafka.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.kafka.consumer.KafkaConsumer;

import java.util.List;
 
@RestController
public class kafkacontroller {
    private KafkaTemplate<String, String> template;
    private KafkaConsumer kafkaConsumer;
 
    public kafkacontroller(KafkaTemplate<String, String> template) {
        this.template = template;
    }
 
    @GetMapping("/kafka/produce")
    public void produce(@RequestParam String message) {
        template.send("kafkaTutorial", message);
    }
    @GetMapping("/kafka/messages")
    public List<String> getMessages() {
        return kafkaConsumer.getMessages();
    }
}
