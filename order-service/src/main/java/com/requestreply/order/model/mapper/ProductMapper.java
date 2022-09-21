package com.requestreply.order.model.mapper;

import model.dto.ProductDTO;
import com.requestreply.order.repository.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDto(Product product);

}
