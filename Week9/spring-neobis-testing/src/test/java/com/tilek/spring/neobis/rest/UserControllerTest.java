package com.tilek.spring.neobis.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tilek.spring.neobis.entity.User;
import com.tilek.spring.neobis.model.UserModel;
import com.tilek.spring.neobis.model.enums.Role;
import com.tilek.spring.neobis.model.enums.Status;
import com.tilek.spring.neobis.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private UserRepository userRepository;

    @Test
    @Order(8)
    void canGetAllUsers() throws Exception {
        mockMvc.perform(
                        get("http://localhost:8080/api/v1/users"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Order(2)
    void canGetAllUsersByFirstName() throws Exception {
        mockMvc.perform(
                        get("http://localhost:8080/api/v1/users/usersFirstName/{firstName}", "Khabib"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Order(3)
    void canGetUserById() throws Exception {
        mockMvc.perform(
                        get("http://localhost:8080/api/v1/users/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Order(4)
    void canGetUserByEmail() throws Exception {
        mockMvc.perform(
                        get("http://localhost:8080/api/v1/users/userEmail/{email}", "user@gmail.com"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Order(5)
    void canCreateUser() throws Exception {
        UserModel userModel = UserModel.builder()
                .firstName("Zair")
                .lastName("ibn Umair")
                .email("zair@gmail.com")
                .password("umair")
                .role(Role.MANAGER)
                .status(Status.ACTIVE)
                .build();

        String content = mapper.writeValueAsString(userModel);

        mockMvc.perform(
                        post("http://localhost:8080/api/v1/users")
                                .content(content)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @Order(6)
    void canUpdateUser() throws Exception {
        User user = userRepository.findByEmail("zair@gmail.com").orElseThrow();

        UserModel userModel = UserModel.builder()
                .firstName("Zair")
                .lastName("Umair")
                .email("zair@gmail.com")
                .password("zair")
                .role(Role.MANAGER)
                .status(Status.ACTIVE)
                .build();

        String content = mapper.writeValueAsString(userModel);

        mockMvc.perform(
                        put("http://localhost:8080/api/v1/users/{id}", user.getUserId())
                                .content(content)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Order(7)
    void canDeleteUser() throws Exception {
        User user = userRepository.findByEmail("zair@gmail.com").orElseThrow();

        mockMvc.perform(
                        delete("http://localhost:8080/api/v1/users/{id}", user.getUserId()))
                .andDo(print())
                .andExpect(status().isOk());
    }
}