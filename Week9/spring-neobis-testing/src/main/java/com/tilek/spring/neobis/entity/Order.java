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
    Long orderId;
    @Column(name = "amount", nullable = false)
    int amount;
    @Column(name = "price", nullable = false)
    Double price;
    @Column(name = "country", nullable = false)
    String country;
    @Column(name = "city", nullable = false)
    String city;
    @Column(name = "address", nullable = false)
    String address;
    @Temporal(TemporalType.DATE)
    Date orderDate;
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(
            name = "product_id",
            referencedColumnName = "productId",
            foreignKey = @ForeignKey(name = "product_id_fk")
    )
    Product productId;
}
