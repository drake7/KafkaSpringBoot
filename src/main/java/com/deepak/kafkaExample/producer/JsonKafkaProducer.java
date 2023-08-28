package com.deepak.kafkaExample.producer;

import com.deepak.kafkaExample.payload.PayLoad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static Logger logger = LoggerFactory.getLogger(JsonKafkaProducer.class);


    private KafkaTemplate<String, PayLoad> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String,PayLoad> kafkaTemplate)
    {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(PayLoad data)
    {
        logger.info(String.format("message sent-> %s",data.toString()));
        Message<PayLoad> payLoadMessage = MessageBuilder.withPayload(data)
                .setHeader(KafkaHeaders.TOPIC,"myTopic_json").build();

        kafkaTemplate.send(payLoadMessage);
    }
}
