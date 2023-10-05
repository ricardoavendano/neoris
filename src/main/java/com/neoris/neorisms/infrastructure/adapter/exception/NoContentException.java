package com.neoris.neorisms.infrastructure.adapter.exception;

public class NoContentException extends RuntimeException {
  public NoContentException() {
    super();
  }

  public NoContentException(String message) {
    super(message);
  }
}
