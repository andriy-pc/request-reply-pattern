package com.requestreply.order.repository.entity;

import enums.OrderStatusConverter;
import enums.OrderStatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

  @Id private Integer id;

  @Column(name = "original_order_id")
  private String originalOrderId;

  @Column(name = "status")
  @Convert(converter = OrderStatusConverter.class)
  private OrderStatusEnum status;

  @OneToMany
  @JoinColumn(name = "order_id")
  private List<OrderEntry> orderEntries;
}
