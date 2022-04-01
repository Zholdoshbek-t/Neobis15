package com.tilek.spring.neobis.rest;

import com.tilek.spring.neobis.entity.User;
import com.tilek.spring.neobis.model.UserModel;
import com.tilek.spring.neobis.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('user:read')")
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("usersFirstName/{firstName}")
    @PreAuthorize("hasAuthority('user:read')")
    List<User> getAllUsersByFirstName(@PathVariable String firstName) { return userService.getAllUsersByFirstName(firstName); }

    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('user:read')")
    ResponseEntity<User> getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/userEmail/{email}")
    @PreAuthorize("hasAuthority('user:read')")
    ResponseEntity<User> getUserByEmail(@PathVariable String email) { return userService.getUserByEmail(email); }

    @PostMapping
    @PreAuthorize("hasAuthority('user:write')")
    User createUser(@RequestBody UserModel userModel) {
        return userService.createUser(userModel);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('user:write')")
    ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody UserModel userDetails) {
        return userService.updateUser(id, userDetails);
    }

    @DeleteMapping("{id}")
    ResponseEntity<User> deleteUser(@PathVariable long id) {
        return userService.deleteUser(id);
    }
}
