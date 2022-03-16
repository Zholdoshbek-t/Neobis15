package com.tilek.spring.neobis.service;

import com.tilek.spring.neobis.model.User;
import com.tilek.spring.neobis.web.dto.UserRegistrationDto;

public interface UserService {
    User save(UserRegistrationDto registrationDto);
}
