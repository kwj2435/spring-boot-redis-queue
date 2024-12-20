package com.uijin.queue.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueueService {

  private final RedisTemplate<String, String> redisTemplate;

  /** 사용자 요청 대기열 추가 */
  public void addRequestToQueue(String request) {
    redisTemplate.opsForList().leftPush("serviceWaitingQueue", request);
  }
}
