package com.ada.order.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CpfValidationError extends Exception{
  private String description;
}
