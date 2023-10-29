package com.ada.order.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class OrderResponse {
  private Integer id;
  private Integer idUser;
  private String cpfUser;
  private LocalDateTime requestDate;
  private String typeCurrency;
  private String valueForeignCurrency;
  private String quotationValue;
  private String valueTotalOperation;
  private String withdrawalAgencyNumber;
}
