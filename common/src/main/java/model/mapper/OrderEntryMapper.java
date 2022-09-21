package model.mapper;

import model.dto.OrderEntryDTO;
import model.entity.OrderEntry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = {ProductMapper.class})
public interface OrderEntryMapper {

    @Mapping(target = "productDTO", source = "orderEntry.product")
    OrderEntryDTO toDto(OrderEntry orderEntry);

}
