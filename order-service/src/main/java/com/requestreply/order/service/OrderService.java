package com.requestreply.order.service;

import model.dto.OrderDTO;

public interface OrderService {

    OrderDTO getByOriginalOrderId(String originalOrderId);

    Boolean ship(String originalOrderId);

}
