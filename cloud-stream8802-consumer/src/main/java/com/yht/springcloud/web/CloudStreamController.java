package com.yht.springcloud.web;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@EnableBinding(Sink.class)
public class CloudStreamController {

    @StreamListener(Sink.INPUT)
    public void listen(Message<String> message) {
        System.out.println("收到的信息是: " + message.getPayload());
    }
}
