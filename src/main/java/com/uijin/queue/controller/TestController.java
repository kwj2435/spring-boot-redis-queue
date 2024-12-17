package com.uijin.queue.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class TestController {

  @GetMapping
  public void test() {
    System.out.println();
  }

  @PostMapping("/test")
  public void test1() {
    System.out.println("test");
  }
}
