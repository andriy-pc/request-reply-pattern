package model.mapper;

import model.dto.ProductDTO;
import model.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDto(Product product);

}
