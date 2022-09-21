package com.requestreply.order.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

  @Id private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "stock_quantity")
  private Integer stockQuantity;

  @Column(name = "price")
  private BigDecimal price;
}
