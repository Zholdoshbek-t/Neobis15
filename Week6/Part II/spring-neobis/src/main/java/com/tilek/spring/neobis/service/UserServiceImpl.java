package com.tilek.spring.neobis.service;

import com.tilek.spring.neobis.model.Role;
import com.tilek.spring.neobis.model.Status;
import com.tilek.spring.neobis.model.User;
import com.tilek.spring.neobis.repository.UserRepository;
import com.tilek.spring.neobis.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override// email password fn ln role status
    public User save(UserRegistrationDto registrationDto) {
        User user = new User(
                registrationDto.getEmail(), passwordEncoder().encode(registrationDto.getPassword()),
                registrationDto.getFirstName(), registrationDto.getLastName(),
                Role.USER, Status.ACTIVE
        );
        return userRepository.save(user);
    }

    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

}
