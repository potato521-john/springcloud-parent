package com.yht.springcloud.service.impl;

import com.yht.springcloud.service.IMessageProvider;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

@EnableBinding(Source.class) //消息的推送管道
public class IMessageProviderImpl implements IMessageProvider {

    @Autowired
    private MessageChannel output;

    @Override
    public String send(String message) {
        message = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(message).build());
        return null;
    }

}
