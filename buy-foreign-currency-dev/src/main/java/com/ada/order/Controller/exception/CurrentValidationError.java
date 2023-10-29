package com.ada.order.controller.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CurrentValidationError extends Exception{
  private String description;
}
