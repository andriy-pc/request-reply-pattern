package com.requestreply.order.service.service;

import com.requestreply.order.service.model.dto.OrderDTO;

public interface OrderService {

    OrderDTO getByOriginalOrderId(String originalOrderId);

    Boolean ship(String originalOrderId);

}
