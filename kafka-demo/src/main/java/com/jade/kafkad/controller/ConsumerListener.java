package com.jade.kafkad.controller;

import com.jade.kafkad.service.WebsocketService;
import com.jade.kafkad.common.ChcpConstants;
import com.jade.kafkad.util.JsonHelper;
import com.jade.kafkad.domain.Message;
import com.jade.kafkad.domain.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerListener.class);

    @Autowired
    private WebsocketService websocketService;

    @KafkaListener(topics = ChcpConstants.Constants.KAFKA_LISTENER_TOPIC)
    public void consumer(String message) {

        logger.info("consumer topic string get : {}", message);

        Message messageReq = new Message();
        messageReq.setMessage(message);

        logger.info("send websocket request : {}", JsonHelper.toJson(messageReq).toString());

        Response response = websocketService.send(messageReq);

        logger.info("send websocket response : {}", JsonHelper.toJson(response).toString());

    }

}
