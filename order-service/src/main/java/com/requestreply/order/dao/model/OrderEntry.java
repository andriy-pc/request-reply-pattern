package com.requestreply.order.dao.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_entry")
@Getter
@Setter
public class OrderEntry {

    @Id
    private Integer id;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "ordered_qty")
    private Integer orderedQty;

    @Column(name = "order_entry_price")
    private BigDecimal orderEntryPrice;

}
