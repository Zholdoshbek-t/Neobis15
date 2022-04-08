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
    Long productId;
    @Column(name = "name", nullable = false, unique = true)
    String name;
    @Column(name = "price", nullable = false)
    int price;
    @Column(name = "amount", nullable = false)
    int amount;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(
        name = "warehouse_id",
        referencedColumnName = "warehouseId",
        foreignKey = @ForeignKey(name = "warehouse_id_fk")
    )
    private Warehouse warehouse;

}
