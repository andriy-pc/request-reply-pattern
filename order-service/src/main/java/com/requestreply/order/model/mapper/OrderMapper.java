package com.requestreply.order.model.mapper;

import model.dto.OrderDTO;
import com.requestreply.order.repository.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = {OrderEntryMapper.class})
public interface OrderMapper {

    OrderDTO toDto(Order order);

    Order toEntity(OrderDTO orderDTO);

}
