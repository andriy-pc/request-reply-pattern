package com.requestreply.order.repository;

import com.requestreply.order.repository.entity.Order;

public interface OrderRepository {

  Order findByOriginalOrderId(String originalOrderId);

  Order update(Order order);
}
