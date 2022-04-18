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

    private Long productId;
    private String name;
    private int price;
    private int amount;
    private Warehouse warehouse;
}
