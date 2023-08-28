package com.deepak.kafkaExample.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private KafkaTemplate<String,String> kafkaTemplate;


    @Value("${spring.kafka.topic.name}")
    private String topicName;
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    public KafkaProducer(KafkaTemplate<String,String> kafkaTemplate)
    {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        logger.info("message:",message);
        kafkaTemplate.send(topicName,message);
    }
}
