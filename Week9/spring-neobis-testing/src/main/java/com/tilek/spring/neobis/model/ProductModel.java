package com.tilek.spring.neobis.model;

import com.tilek.spring.neobis.entity.Warehouse;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductModel {

    Long productId;
    String name;
    int price;
    int amount;
    Warehouse warehouse;
}
