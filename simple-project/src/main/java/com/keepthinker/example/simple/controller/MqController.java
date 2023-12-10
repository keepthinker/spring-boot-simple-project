package com.keepthinker.example.simple.controller;

import com.keepthinker.example.simple.config.RocketMqProperties;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MqController {
    private Logger logger = LoggerFactory.getLogger(MqController.class);

    @Autowired
    private RocketMqProperties rocketMqProperties;
    @Autowired
    private RocketMQTemplate rocketMQTemplate;


    @RequestMapping("/produce")
    public String produce(@RequestParam("msgBody") String msgBody,
                          @RequestParam("delay") Boolean delay,
                          @RequestParam("delaySeconds") Integer delaySeconds) {

        Message<String> message = MessageBuilder.withPayload(msgBody).build();
        if (delay) {
            if (delaySeconds == null) {
                rocketMQTemplate.asyncSend(rocketMqProperties.getTopic(), message, new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        logger.info("on success|sendResult:{}", sendResult);
                    }

                    @Override
                    public void onException(Throwable throwable) {
                        logger.info("on exception|throwableMsg:{}", throwable.getMessage());
                    }
                }, 3000, 3);
            } else {
                logger.info("on success|sendResult:{}", message.getPayload());
                rocketMQTemplate.syncSendDelayTimeSeconds(rocketMqProperties.getTopic(),
                        message, delaySeconds);
            }

        } else {
            rocketMQTemplate.asyncSend(rocketMqProperties.getTopic(), message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    logger.info("on success|sendResult:{}", sendResult);
                }

                @Override
                public void onException(Throwable throwable) {
                    logger.info("on exception|throwableMsg:{}", throwable.getMessage());
                }
            });
        }

        return "{\"code\": 0}";
    }

}
