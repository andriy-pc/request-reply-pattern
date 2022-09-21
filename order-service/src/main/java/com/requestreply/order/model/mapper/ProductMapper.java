package com.requestreply.order.model.mapper;

import com.requestreply.order.model.dto.ProductDTO;
import com.requestreply.order.model.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDto(Product product);

}
