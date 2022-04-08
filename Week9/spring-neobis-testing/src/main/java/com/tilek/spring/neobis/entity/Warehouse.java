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
@Table(name = "warehouse")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long warehouseId;
    @Column(name = "address", nullable = false, unique = true)
    String address;
    @Column(name = "city", nullable = false)
    String city;
    @Column(name = "country", nullable = false)
    String country;
}
