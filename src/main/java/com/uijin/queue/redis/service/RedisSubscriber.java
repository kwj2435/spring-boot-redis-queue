package com.uijin.queue.redis.service;

import org.springframework.stereotype.Component;

@Component
public class RedisSubscriber {

  public void onMessage(String message) {
    // 메시지가 도착하면 처리할 로직
    System.out.println("Received message: " + message);
  }
}
