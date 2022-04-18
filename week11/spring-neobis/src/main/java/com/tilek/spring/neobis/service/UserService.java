package com.tilek.spring.neobis.service;

import com.tilek.spring.neobis.entity.User;
import com.tilek.spring.neobis.model.UserModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    User createUser(UserModel userModel);
    List<User> getAllUsers();
    List<User> getAllUsersByFirstName(String firstName);
    ResponseEntity<User> getUserByEmail(String email);
    ResponseEntity<User> getUserById(long id);
    ResponseEntity<User> updateUser(long id, UserModel userDetails);
    ResponseEntity<User> deleteUser(long id);

}
