package com.requestreply.order.model.mapper;

import model.dto.OrderEntryDTO;
import com.requestreply.order.repository.entity.OrderEntry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = {ProductMapper.class})
public interface OrderEntryMapper {

    @Mapping(target = "productDTO", source = "orderEntry.product")
    OrderEntryDTO toDto(OrderEntry orderEntry);

}
