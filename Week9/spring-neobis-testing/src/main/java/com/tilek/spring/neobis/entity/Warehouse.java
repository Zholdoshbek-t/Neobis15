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
    @Column(nullable = false, unique = true)
    String address;
    @Column(nullable = false)
    String city;
    @Column(nullable = false)
    String country;

}
