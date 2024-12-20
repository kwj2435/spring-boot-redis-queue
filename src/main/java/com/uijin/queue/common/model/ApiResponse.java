package com.uijin.queue.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uijin.queue.exception.enums.ApiExceptionCode;
import lombok.Getter;

@Getter
public class ApiResponse<T> {

  // API Response Code
  private String code;

  // API Response Message
  @JsonIgnore
  private String message;

  // API Response Data
  private T data;

  // Constructor
  private ApiResponse(String code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public static <T> ApiResponse<T> success(T data) {
    return new ApiResponse<>("200", null, data);
  }

  // 오류 응답 생성
  public static ApiResponse<Object> error(ApiExceptionCode exceptionCode) {
    return new ApiResponse<>(exceptionCode.getCode(), exceptionCode.getMessage(), null);
  }
}
