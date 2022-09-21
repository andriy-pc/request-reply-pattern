package com.requestreply.order.service.model.mapper;

import com.requestreply.order.service.model.dto.ProductDTO;
import com.requestreply.order.service.model.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDto(Product product);

}
