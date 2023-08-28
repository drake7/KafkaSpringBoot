package com.deepak.kafkaExample.consumer;

import com.deepak.kafkaExample.payload.PayLoad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer
{
    private static final Logger logger = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "myTopic_json",groupId = "myGroup")
    private void consume(PayLoad user)
    {
        logger.info("Message Information:"+user.toString());
    }

}
