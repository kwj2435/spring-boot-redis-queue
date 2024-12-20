package com.uijin.queue.app.controller;

import com.uijin.queue.app.service.QueueService;
import com.uijin.queue.redis.service.RedisPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * 클라이언트에게 실시간으로 대기열 상황을 보여줘야한다.
 *  -> Server-Sent-Events, 타임 리프 이용 구현
 * 클라이언트의 차례가 되면 특정 사이트로 접속 되도록 처리 해야한다.
 *  -> 리디렉션 처리
 * 클라이언트의 차례가 아니라면 특정 사이트로 접속되지 않는다.
 *  -> 토큰 기반 인증을 통해 방지
 * 대기열 기능을 통해 접속자수를 조절한다. (어떻게 ?)
 *  사용자가 몇명 들어와 있는지, 몇명이 나갔는지 어떻게 확인할 수 있지?
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/queue")
public class QueueController {

  private final RedisPublisher redisPublisher;
  private final QueueService queueService;

  /**
   * 사용자 요청 대기열 추가
   */
  @PostMapping
  public void addQueue() {
    queueService.addRequestToQueue("12345");
  }

  /** 메시지 발행 요청 처리 */
  @PostMapping("/publish")
  public void publishMessage(@RequestParam String message) {
    redisPublisher.publishMessage(message);
    System.out.println();
  }
}
