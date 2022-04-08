package com.tilek.spring.neobis.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tilek.spring.neobis.entity.Warehouse;
import com.tilek.spring.neobis.model.WarehouseModel;
import com.tilek.spring.neobis.repository.WarehouseRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
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
class WarehouseControllerTest {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Test
    @Order(5)
    void canGetAllWarehouses() throws Exception {
        mockMvc.perform(
                        get("http://localhost:8080/api/v1/warehouses"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Order(4)
    void canGetWarehouseById() throws Exception {
        mockMvc.perform(
                        get("http://localhost:8080/api/v1/warehouses/{id}", 2L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Order(1)
    void canCreateWarehouse() throws Exception {
        WarehouseModel warehouse = WarehouseModel.builder()
                .address("Vokzal 10/5")
                .city("Naryn")
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
    @Order(2)
    void canUpdateWarehouse() throws Exception {
        Warehouse warehouse = warehouseRepository.findByAddress("Vokzal 10/5").orElseThrow();
        WarehouseModel warehouseModel = WarehouseModel.builder()
                .address("Kok Jar 21")
                .city("Bishkek")
                .country("Kyrgyzstan")
                .build();

        String jsonRequest = mapper.writeValueAsString(warehouseModel);

        mockMvc.perform(
                        put("http://localhost:8080/api/v1/warehouses/{id}", warehouse.getWarehouseId())
                                .content(jsonRequest)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Order(3)
    void canDeleteWarehouse() throws Exception {
        Warehouse warehouse = warehouseRepository.findByAddress("Kok Jar 21").orElseThrow();

        mockMvc.perform(
                        delete("http://localhost:8080/api/v1/warehouses/{id}", warehouse.getWarehouseId()))
                .andDo(print())
                .andExpect(status().isOk());
    }
}