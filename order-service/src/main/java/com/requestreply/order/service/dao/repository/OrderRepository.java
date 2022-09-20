package com.requestreply.order.service.dao.repository;

import com.requestreply.order.service.model.entity.Order;

public interface OrderRepository {

    Order findByOriginalOrderId(String originalOrderId);

    Order update(Order order);

}
