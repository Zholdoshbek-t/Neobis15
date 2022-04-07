package com.tilek.spring.neobis.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tilek.spring.neobis.entity.Product;
import com.tilek.spring.neobis.entity.Warehouse;
import com.tilek.spring.neobis.model.ProductModel;
import com.tilek.spring.neobis.repository.ProductRepository;
import com.tilek.spring.neobis.repository.WarehouseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void canGetAllProduct() throws Exception {
        mockMvc.perform(
                get("http://localhost:8080/api/v1/products"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void canGetProductById() throws Exception {
        mockMvc.perform(
                        get("http://localhost:8080/api/v1/products/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void canCreateProduct() throws Exception {
        Warehouse warehouse = warehouseRepository.findById(2L).orElseThrow();
        Product model = Product.builder()
                .name("Samsung Galaxy S6")
                .amount(400)
                .price(500)
                .warehouse(warehouse)
                .build();
        String jsonRequest = mapper.writeValueAsString(model);
        mockMvc.perform(
                post("http://localhost:8080/api/v1/products")
                        .content(jsonRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void canUpdateProduct() throws Exception {
        Warehouse warehouse = warehouseRepository.findById(1L).orElseThrow();
        ProductModel productModel = ProductModel.builder()
                .productId(4L)
                .name("Iphone XS")
                .amount(500)
                .price(830)
                .warehouse(warehouse)
                .build();
        String jsonRequest = mapper.writeValueAsString(productModel);
        Product product = productRepository.findByName("Samsung Galaxy S6").orElseThrow();
        mockMvc.perform(
                put("http://localhost:8080/api/v1/products/{id}", product.getProductId())
                        .content(jsonRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void canDeleteProduct() throws Exception {
        Product product = productRepository.findByName("Iphone XS").orElseThrow();
        mockMvc.perform(
                delete("http://localhost:8080/api/v1/products/{id}", product.getProductId()))
                .andDo(print())
                .andExpect(status().isOk());
    }
}