package com.tilek.spring.neobis.service;

import com.tilek.spring.neobis.exception.ResourceNotFoundException;
import com.tilek.spring.neobis.model.UserModel;
import com.tilek.spring.neobis.entity.User;
import com.tilek.spring.neobis.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(UserModel userModel) {
        User user = new User();
        mergeUser(user, userModel);

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllUsersByFirstName(String firstName) {
        return userRepository.findUserByFirstName(firstName);
    }

    @Override
    public ResponseEntity<User> getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User was not found"));

        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<User> getUserById(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User was not found"));

        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<User> updateUser(long id, UserModel userDetails) {
        User updateUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User was not found"));

        mergeUser(updateUser, userDetails);

        userRepository.save(updateUser);

        return ResponseEntity.ok(updateUser);
    }

    @Override
    public ResponseEntity<User> deleteUser(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User was not found"));

        userRepository.deleteById(id);

        return ResponseEntity.ok(user);
    }

    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    private void mergeUser(User updateUser, UserModel userDetails) {
        updateUser.setFirstName(userDetails.getFirstName());
        updateUser.setLastName(userDetails.getLastName());
        updateUser.setEmail(userDetails.getEmail());
        updateUser.setRole(userDetails.getRole());
        updateUser.setStatus(userDetails.getStatus());
    }
}
