package com.neoris.neorisms.infrastructure.adapter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionConf {

  @ExceptionHandler(NoContentException.class)
  public ResponseEntity<Error> handle(NoContentException e) {
    Error error = new Error();
    error.setCode(HttpStatus.NO_CONTENT.name());
    error.setMessage(e.getMessage());
    return new ResponseEntity<>(error, HttpStatus.NO_CONTENT);
  }
}
