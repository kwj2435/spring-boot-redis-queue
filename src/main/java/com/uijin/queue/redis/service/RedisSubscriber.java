package com.uijin.queue.redis.service;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class RedisSubscriber implements MessageListener {

  @Override
  public void onMessage(Message message, byte[] pattern) {
    String channel = new String(pattern);
    String body = new String(message.getBody());
    System.out.println("Received message: " + body + " from channel: " + channel);
  }
}
