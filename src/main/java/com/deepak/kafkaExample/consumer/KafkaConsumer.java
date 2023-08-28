package com.deepak.kafkaExample.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "myGroup")
public void message(String  message)
{
logger.info("Message Received:"+message);
}
}
