package com.tilek.spring.neobis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(
        name = "`order`"
)
public class Order {

    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    private Long orderId;
    @Column(nullable = false)
    private int amount;
    @Column(nullable = false)
    private Double price;
    private String country;
    private String city;
    @Column(nullable = false)
    private String address;
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @ManyToOne(
            cascade = CascadeType.MERGE,
            optional = false
    )
    @JoinColumn(
            name = "product_id",
            referencedColumnName = "productId",
            nullable = false
    )
    private Product product;
}
