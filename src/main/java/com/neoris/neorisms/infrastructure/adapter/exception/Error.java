package com.neoris.neorisms.infrastructure.adapter.exception;

import lombok.Data;

@Data
public class Error {
  private String code;
  private String message;
}
