package com.requestreply.order.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntryDTO {

    private ProductDTO productDTO;

    private Integer orderedQty;

    private BigDecimal orderEntryPrice;
}
