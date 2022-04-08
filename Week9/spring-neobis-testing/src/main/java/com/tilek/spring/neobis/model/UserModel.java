package com.tilek.spring.neobis.model;

import com.tilek.spring.neobis.model.enums.Role;
import com.tilek.spring.neobis.model.enums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserModel {

    String email;
    String password;
    String firstName;
    String lastName;
    Role role;
    Status status;
}
