package com.tilek.spring.neobis.model;

import com.tilek.spring.neobis.entity.Product;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderModel {

    int amount;
    Double price;
    String country;
    String city;
    String orderAddress;
    Date orderDate;
    Product product;
}
