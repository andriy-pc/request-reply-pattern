package com.requestreply.order.service.enums;

import lombok.Getter;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public enum OrderStatusEnum {

    CREATED("created"),
    SHIPPING_REQUESTED("shipping requested"),
    SHIPPING("shipping"),
    SHIPPED("shipped"),
    CANCELLED("cancelled");

    static Map<String, OrderStatusEnum> namePerStatus = Stream.of(values())
            .collect(Collectors.toMap(OrderStatusEnum::getName, status -> status));

    String getName() {
        return name;
    }

    private String name;

    OrderStatusEnum(String name) {
        this.name = name;
    }

    public static OrderStatusEnum getByName(String orderStatusName) {
        return namePerStatus.get(orderStatusName);
    }

}
