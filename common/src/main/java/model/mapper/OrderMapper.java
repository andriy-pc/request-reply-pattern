package model.mapper;

import model.dto.OrderDTO;
import model.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = {OrderEntryMapper.class})
public interface OrderMapper {

    OrderDTO toDto(Order order);

}
