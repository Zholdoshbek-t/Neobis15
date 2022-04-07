package com.tilek.spring.neobis.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tilek.spring.neobis.entity.Order;
import com.tilek.spring.neobis.entity.Product;
import com.tilek.spring.neobis.model.OrderModel;
import com.tilek.spring.neobis.repository.OrderRepository;
import com.tilek.spring.neobis.repository.ProductRepository;
import com.tilek.spring.neobis.service.OrderService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderService orderService;

    @Autowired
    private ObjectMapper mapper;

    public OrderControllerTest(){
        mapper = new ObjectMapper();
    }

    @Test
    void getAllOrder() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/v1/orders"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void canGetOrderById() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/v1/orders/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void createOrder() throws Exception {
        Product product = productRepository.findById(1L).orElseThrow();
        OrderModel order1 = OrderModel.builder()
                .amount(2)
                .price(2400D)
                .country("Kyrgyzstan")
                .city("Bishkek")
                .orderDate(new GregorianCalendar(2022, 3, 10).getTime())
                .address("Asanbay 40/58")
                .product(product)
                .build();

        String jsonRequest = mapper.writeValueAsString(order1);

        mockMvc.perform(
                        post("http://localhost:8080/api/v1/orders")
                                .content(jsonRequest)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void updateOrder() throws Exception {
        Product product = productRepository.findById(3L).orElseThrow();
        OrderModel orderModel = OrderModel.builder()
                .amount(4)
                .price(1200D)
                .country("Kyrgyzstan")
                .city("Osh")
                .orderDate(new GregorianCalendar(2022, Calendar.MARCH, 29).getTime())
                .address("Zaryad 10E")
                .product(product)
                .build();

        String jsonRequest = mapper.writeValueAsString(orderModel);

        mockMvc.perform(
                put("http://localhost:8080/api/v1/orders/{id}", 12L)
                        .content(jsonRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteOrder() throws Exception {

        mockMvc.perform(
                delete("http://localhost:8080/api/v1/orders/{id}", 12L))
                .andDo(print())
                .andExpect(status().isOk());
    }


}