package com.requestreply.order.model.mapper;

import com.requestreply.order.model.dto.OrderDTO;
import com.requestreply.order.model.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = {OrderEntryMapper.class})
public interface OrderMapper {

    OrderDTO toDto(Order order);

}
