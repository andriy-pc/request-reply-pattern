package com.requestreply.order.model.dto;

import com.requestreply.order.enums.OrderStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private String originalOrderId;

    private OrderStatusEnum status;

    private List<OrderEntryDTO> orderEntries;

}
