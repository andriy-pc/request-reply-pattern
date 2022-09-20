package com.requestreply.order.service.model.mapper;

import com.requestreply.order.service.model.dto.OrderDTO;
import com.requestreply.order.service.model.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = {OrderEntryMapper.class})
public interface OrderMapper {

    OrderDTO toDto(Order order);

}
