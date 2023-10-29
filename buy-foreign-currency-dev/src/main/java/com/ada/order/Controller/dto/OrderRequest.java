package com.ada.order.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class OrderRequest {
  private String cpfUser;
  private LocalDateTime requestDate;
  private String typeCurrency;
  private BigDecimal valueForeignCurrency;
  private BigDecimal quotationValue;
  private BigDecimal valueTotalOperation;
  private String withdrawalAgencyNumber;
}
