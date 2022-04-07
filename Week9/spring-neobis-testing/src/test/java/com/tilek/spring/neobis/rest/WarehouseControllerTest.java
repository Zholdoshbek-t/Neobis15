package com.tilek.spring.neobis.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tilek.spring.neobis.entity.Warehouse;
import com.tilek.spring.neobis.model.WarehouseModel;
import org.junit.jupiter.api.Test;
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
class WarehouseControllerTest {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void canGetAllWarehouses() throws Exception {
        mockMvc.perform(
                get("http://localhost:8080/api/v1/warehouses"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void canGetWarehouseById() throws Exception {
        mockMvc.perform(
                get("http://localhost:8080/api/v1/warehouses/{id}", 2L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void canCreateWarehouse() throws Exception {
        WarehouseModel warehouse = WarehouseModel.builder()
                .address("7mkr. 43B")
                .city("Bishkek")
                .country("Kyrgyzstan")
                .build();
        String jsonRequest = mapper.writeValueAsString(warehouse);

        mockMvc.perform(
                post("http://localhost:8080/api/v1/warehouses")
                        .content(jsonRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void canUpdateWarehouse() throws Exception {
    }

    @Test
    void canDeleteWarehouse() throws Exception {
    }
}