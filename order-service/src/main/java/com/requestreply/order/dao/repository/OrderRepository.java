package com.requestreply.order.dao.repository;


import model.entity.Order;

public interface OrderRepository {

    Order findByOriginalOrderId(String originalOrderId);

    Order update(Order order);

}
