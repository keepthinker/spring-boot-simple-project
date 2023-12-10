package com.keepthinker.example.simple.mq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(topic = "${http-action.topic}", consumerGroup = "${http-action.consumer-group}")
public class HttpActionConsumer implements RocketMQListener<String> {

    private Logger logger = LoggerFactory.getLogger(HttpActionConsumer.class);
    @Override
    public void onMessage(String message) {
        logger.info("consumer message from http-action|message:{}", message);
    }
}