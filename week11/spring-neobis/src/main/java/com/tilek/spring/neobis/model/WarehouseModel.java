package com.tilek.spring.neobis.model;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class WarehouseModel {

    private Long warehouseId;
    private String country;
    private String city;
    private String address;
}
