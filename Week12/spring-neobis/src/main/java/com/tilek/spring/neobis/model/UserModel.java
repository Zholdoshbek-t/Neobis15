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

    private Long userId;
    private String email;
    private String firstName;
    private String lastName;
    private Role role;
    private Status status;
}
