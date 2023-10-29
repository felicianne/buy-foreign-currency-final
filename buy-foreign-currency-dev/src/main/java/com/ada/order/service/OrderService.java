package com.ada.order.service;

import com.ada.order.controller.dto.OrderRequest;
import com.ada.order.controller.dto.OrderResponse;
import com.ada.order.controller.exception.CurrentValidationError;
import com.ada.order.model.Order;
import com.ada.order.model.User;
import com.ada.order.repository.IOrderRepository;
import com.ada.order.repository.IUserRepository;
import com.ada.order.utils.OrderConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService {
  private final IOrderRepository orderRepository;
  private final ExchangeService exchangeService;
  private  final IUserRepository userRepository;

  @Autowired
  public OrderService (IOrderRepository orderRepository, ExchangeService exchangeService, IUserRepository userRepository) {
    this.orderRepository = orderRepository;
    this.exchangeService = exchangeService;
    this.userRepository = userRepository;
  }

  public OrderResponse create(OrderRequest orderRequest) throws CurrentValidationError {
    User user = userRepository.findByCpf(orderRequest.getCpfUser());
    Integer idUser = user.getId();
    String currency = orderRequest.getTypeCurrency();

    if (currency.equals("USD") || currency.equals("EUR")){
      BigDecimal rateExchange = exchangeService.getRateExchange(currency);
      BigDecimal valueForeignCurrency = orderRequest.getValueForeignCurrency();

      Order order = OrderConvert.toEntity(orderRequest);
      order.setQuotationValue(rateExchange);
      order.setValueTotalOperation(calcValueTotalOperation(rateExchange, valueForeignCurrency));
      return OrderConvert.toResponse(orderRepository.save(order), idUser);
    }

    throw new CurrentValidationError("TypeCurrency invalid. Use dollar (USD) or euros (EUR)");
  }

  private static BigDecimal calcValueTotalOperation(BigDecimal rateExchange, BigDecimal value){
    return rateExchange.multiply(value);
  }
}
