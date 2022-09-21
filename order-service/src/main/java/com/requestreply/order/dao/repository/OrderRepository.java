package com.requestreply.order.dao.repository;

import com.requestreply.order.model.entity.Order;

public interface OrderRepository {

    Order findByOriginalOrderId(String originalOrderId);

    Order update(Order order);

}
