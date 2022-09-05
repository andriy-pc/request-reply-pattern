package com.requestreply.order.service.dao.repository;

import com.requestreply.order.service.dao.model.Order;

public interface OrderRepository {

    Order findByOriginalOrderId(String originalOrderId);

}
