package com.uijin.queue.redis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisPublisher {

  @Value("${redis.queue.channel}")
  private String channel;

  private final RedisTemplate<String, String> redisTemplate;

  public void publishMessage(String message) {
    redisTemplate.convertAndSend(channel, message); // 메시지를 Redis로 발행
    System.out.println("Published message: " + message + " to channel: " + channel);
  }
}
