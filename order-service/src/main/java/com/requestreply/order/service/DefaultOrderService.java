package com.requestreply.order.service;

import com.requestreply.order.dao.repository.OrderRepository;
import enums.OrderStatusEnum;
import lombok.RequiredArgsConstructor;
import model.dto.OrderDTO;
import model.entity.Order;
import model.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.requestreply.order.constants.GeneralConstants.SHIPMENT_REQUEST_ACCEPTED;


@Service
@RequiredArgsConstructor
public class DefaultOrderService implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    public OrderDTO getByOriginalOrderId(String originalOrderId) {
        return orderMapper.toDto(orderRepository.findByOriginalOrderId(originalOrderId));
    }

    @Transactional(rollbackFor = {Exception.class})
    public Boolean ship(String originalOrderId) {
        Order order = orderRepository.findByOriginalOrderId(originalOrderId);
        order.setStatus(OrderStatusEnum.SHIPPING_REQUESTED);
        orderRepository.update(order);
        return SHIPMENT_REQUEST_ACCEPTED;
    }

}
