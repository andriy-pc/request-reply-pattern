package com.requestreply.shipment.service;

import lombok.RequiredArgsConstructor;
import model.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static enums.OrderStatusEnum.SHIPPING;
import static enums.OrderStatusEnum.SHIPPING_REJECTED;
import static java.lang.Math.random;

@Service
@RequiredArgsConstructor
public class DefaultShipmentService implements ShipmentService {

  private final KafkaTemplate<String, OrderDTO> kafkaTemplate;

  @Value("${listener.topics.shipment.response}")
  private String shipmentResponseTopicName;

  @Override
  public void requestShipping(OrderDTO order) {
    if (random() > 0.6) {
      order.setStatus(SHIPPING_REJECTED);
    }
    order.setStatus(SHIPPING);
    respondForShipmentRequest(order);
  }

  public void respondForShipmentRequest(OrderDTO order) {
    kafkaTemplate.send(shipmentResponseTopicName, order);
  }
}
