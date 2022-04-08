package com.tilek.spring.neobis.entity;

import com.tilek.spring.neobis.model.enums.Role;
import com.tilek.spring.neobis.model.enums.Status;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;
    @Column(unique = true)
    String email;
    @Column(name = "password")
    String password;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    Role role;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    Status status;

}