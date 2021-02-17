package com.Kafka.Kafka.resource;

import com.Kafka.Kafka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserResource {
    @Autowired
    KafkaTemplate<String, User> kafkaTemplate;
    private static final String TOPIC = "Kafka_Example";
    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name){
        kafkaTemplate.send(TOPIC,new User(name,"Technology",120000L));
        return "Published successfully";
    }
}
