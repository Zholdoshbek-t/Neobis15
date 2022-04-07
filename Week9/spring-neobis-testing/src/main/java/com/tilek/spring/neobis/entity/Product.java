package com.tilek.spring.neobis.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "price", nullable = false)
    private int price;
    @Column(name = "amount", nullable = false)
    private int amount;

    @ManyToOne(cascade = CascadeType.MERGE,optional = false)
    @JoinColumn(
        name = "warehouse_id",
        referencedColumnName = "warehouseId"
    )
    private Warehouse warehouse;

}
