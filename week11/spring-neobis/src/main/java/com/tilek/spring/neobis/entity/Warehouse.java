package com.tilek.spring.neobis.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "warehouse")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long warehouseId;
    @Column(nullable = false)
    String country;
    @Column(nullable = false)
    String city;
    @Column(nullable = false, unique = true)
    String address;

}
