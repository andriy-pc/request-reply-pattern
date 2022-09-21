package com.requestreply.order.integration;

import com.requestreply.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import model.dto.OrderDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageListener {

  private final OrderService orderService;

  @KafkaListener(id = "orders", topics = "shipment-response")
  private void listenForOrderShipment(OrderDTO orderDTO) {
    orderService.processShipmentResponse(orderDTO);
  }
}
