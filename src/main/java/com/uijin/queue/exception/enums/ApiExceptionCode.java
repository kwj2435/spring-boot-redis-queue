package com.uijin.queue.exception.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ApiExceptionCode {
  ERR_400_100001(HttpStatus.BAD_REQUEST, "400_100001", "잘못된 파라미터 입니다.");

  ApiExceptionCode(HttpStatus httpStatus, String code, String message) {
    this.httpStatus = httpStatus;
    this.code = code;
    this.message = message;
  }

  private HttpStatus httpStatus;
  private String code;
  private String message;
}
