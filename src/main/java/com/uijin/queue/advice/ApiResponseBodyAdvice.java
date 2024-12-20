package com.uijin.queue.advice;

import com.uijin.queue.common.model.ApiResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class ApiResponseBodyAdvice implements ResponseBodyAdvice<Object> {

  @Override
  public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
    return false;
  }

  @Override
  public Object beforeBodyWrite(
          Object body, MethodParameter returnType, MediaType selectedContentType,
          Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
          ServerHttpResponse response) {

    if(body instanceof ResponseEntity<?>) {
      return body;
    }

    return ResponseEntity.ok(ApiResponse.success(body));
  }
}