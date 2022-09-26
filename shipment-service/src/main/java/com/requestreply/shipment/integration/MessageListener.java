package com.requestreply.shipment.integration;

import com.requestreply.shipment.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import model.dto.OrderDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageListener {

  private final ShipmentService shipmentService;

  @KafkaListener(id = "${listener.id}", topics = "${listener.topics.shipment.request}")
  private void listenForOrderShipment(OrderDTO order) {
    shipmentService.requestShipping(order);
  }
}
