package com.requestreply.shipment.service;

import model.dto.OrderDTO;

public interface ShipmentService {

  void requestShipping(OrderDTO order);
}
