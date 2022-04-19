package com.tilek.spring.neobis.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
