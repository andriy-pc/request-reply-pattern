package com.requestreply.order.service;

import com.requestreply.order.model.mapper.OrderMapper;
import com.requestreply.order.repository.OrderRepository;
import com.requestreply.order.repository.entity.Order;
import enums.OrderStatusEnum;
import lombok.RequiredArgsConstructor;
import model.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.requestreply.order.constants.GeneralConstants.SHIPMENT_REQUEST_ACCEPTED;

@Service
@RequiredArgsConstructor
public class DefaultOrderService implements OrderService {

  private final OrderRepository orderRepository;

  private final OrderMapper orderMapper;

  private final KafkaTemplate<String, OrderDTO> kafkaTemplate;

  @Value("${listener.topics.shipment.request}")
  private String shipmentRequestTopicName;

  public OrderDTO getByOriginalOrderId(String originalOrderId) {
    return orderMapper.toDto(orderRepository.findByOriginalOrderId(originalOrderId));
  }

  @Transactional(rollbackFor = {Exception.class})
  public Boolean ship(String originalOrderId) {
    Order order = orderRepository.findByOriginalOrderId(originalOrderId);
    order.setStatus(OrderStatusEnum.SHIPPING_REQUESTED);
    kafkaTemplate.send(shipmentRequestTopicName, orderMapper.toDto(order));
    orderRepository.update(order);
    return SHIPMENT_REQUEST_ACCEPTED;
  }

  @Override
  @Transactional
  public void processShipmentResponse(OrderDTO orderDTO) {
    Order order = orderRepository.findByOriginalOrderId(orderDTO.getOriginalOrderId());
    order.setStatus(orderDTO.getStatus());
    orderRepository.update(order);
  }
}
