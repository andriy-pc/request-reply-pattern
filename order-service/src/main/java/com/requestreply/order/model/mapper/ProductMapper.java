package com.requestreply.order.model.mapper;

import com.requestreply.order.repository.entity.Product;
import model.dto.ProductDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

  ProductDTO toDto(Product product);
}
