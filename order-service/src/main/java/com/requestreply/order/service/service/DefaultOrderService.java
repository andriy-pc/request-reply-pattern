package com.requestreply.order.service.service;

import com.requestreply.order.service.dao.repository.OrderRepository;
import com.requestreply.order.service.enums.OrderStatusEnum;
import com.requestreply.order.service.model.dto.OrderDTO;
import com.requestreply.order.service.model.entity.Order;
import com.requestreply.order.service.model.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.requestreply.order.service.constants.GeneralConstants.SHIPMENT_REQUEST_ACCEPTED;


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
