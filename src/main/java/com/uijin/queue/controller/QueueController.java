package com.uijin.queue.controller;

import com.uijin.queue.redis.service.RedisPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/queue")
public class QueueController {

  @Value("${redis.queue.channel}")
  private String channel;

  private final RedisPublisher redisPublisher;

  /** 메시지 발행 요청 처리 */
  @PostMapping("/publish")
  public String publishMessage(@RequestParam String message) {
    try {
      redisPublisher.publishMessage(channel, message);
    } catch (Exception e) {
      System.out.println();
    }


    return "Message published to queue!";
  }
}
