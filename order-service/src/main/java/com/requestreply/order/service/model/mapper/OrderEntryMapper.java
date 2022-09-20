package com.requestreply.order.service.model.mapper;

import com.requestreply.order.service.model.dto.OrderEntryDTO;
import com.requestreply.order.service.model.entity.OrderEntry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = {ProductMapper.class})
public interface OrderEntryMapper {

    @Mapping(target = "productDTO", source = "orderEntry.product")
    OrderEntryDTO toDto(OrderEntry orderEntry);

}
