package com.tilek.spring.neobis.model;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class WarehouseModel {

    private String address;
    private String city;
    private String country;
}
