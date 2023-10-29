package com.ada.order.controller;

import com.ada.order.controller.dto.OrderRequest;
import com.ada.order.controller.dto.OrderResponse;
import com.ada.order.controller.exception.CurrentValidationError;
import com.ada.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) throws CurrentValidationError{
      OrderResponse order =  orderService.create(orderRequest);
      return ResponseEntity
              .created(URI.create("/"+order.getId()))
              .body(order);
    }
}
