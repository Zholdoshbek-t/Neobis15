package com.tilek.spring.neobis.model;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class WarehouseModel {

    String address;
    String city;
    String country;
}
