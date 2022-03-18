package com.tilek.spring.neobis.rest;

import com.tilek.spring.neobis.exception.ResourceNotFoundException;
import com.tilek.spring.neobis.model.User;
import com.tilek.spring.neobis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('user:read')")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('user:read')")
    ResponseEntity<User> getUserById(@PathVariable long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return ResponseEntity.ok(user);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('user:write')")
    ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User userDetails) {
        User updateUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        updateUser.setEmail(userDetails.getEmail());
        updateUser.setFirstName(userDetails.getFirstName());
        updateUser.setLastName(userDetails.getLastName());
        updateUser.setPassword(userDetails.getPassword());
        updateUser.setRole(userDetails.getRole());
        updateUser.setStatus(userDetails.getStatus());

        userRepository.save(updateUser);

        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("{id}")
    ResponseEntity<User> deleteUser(@PathVariable long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        userRepository.deleteById(id);

        return ResponseEntity.ok(user);
    }
}
