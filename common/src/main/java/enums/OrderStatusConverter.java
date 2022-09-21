package enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class OrderStatusConverter implements AttributeConverter<OrderStatusEnum, String> {

  @Override
  public String convertToDatabaseColumn(OrderStatusEnum orderStatusEnum) {
    return orderStatusEnum.getName();
  }

  @Override
  public OrderStatusEnum convertToEntityAttribute(String orderStatusName) {
    return OrderStatusEnum.getByName(orderStatusName);
  }
}
