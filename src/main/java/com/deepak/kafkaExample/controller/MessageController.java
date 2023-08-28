package com.deepak.kafkaExample.controller;

import com.deepak.kafkaExample.payload.PayLoad;
import com.deepak.kafkaExample.producer.JsonKafkaProducer;
import com.deepak.kafkaExample.producer.KafkaProducer;
import org.apache.kafka.common.protocol.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {
private KafkaProducer kafkaProducer;
private JsonKafkaProducer jsonKafkaProducer;

 public MessageController(KafkaProducer kafkaProducer,JsonKafkaProducer jsonKafkaProducer)
 {
     this.kafkaProducer = kafkaProducer;
     this.jsonKafkaProducer = jsonKafkaProducer;
 }

 @GetMapping("/publish")
 public ResponseEntity<String> publish(@RequestParam("message") String message)
 {
     kafkaProducer.sendMessage(message);
     return ResponseEntity.ok("Message Sent to Topic");
 }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody PayLoad data)
    {
        jsonKafkaProducer.sendMessage(data);
        return ResponseEntity.ok("JSON Message Sent to Topic");
    }

}
