package com.requestreply.order.service;

import com.requestreply.order.model.dto.OrderDTO;

public interface OrderService {

    OrderDTO getByOriginalOrderId(String originalOrderId);

    Boolean ship(String originalOrderId);

}
