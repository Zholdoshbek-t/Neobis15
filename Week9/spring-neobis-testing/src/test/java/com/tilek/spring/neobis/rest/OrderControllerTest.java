package com.tilek.spring.neobis.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tilek.spring.neobis.entity.Order;
import com.tilek.spring.neobis.entity.Product;
import com.tilek.spring.neobis.model.OrderModel;
import com.tilek.spring.neobis.repository.OrderRepository;
import com.tilek.spring.neobis.repository.ProductRepository;
import com.tilek.spring.neobis.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
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
        Order order1 = new Order();
        order1.setOrderId(4L);
        order1.setAmount(2);
        order1.setPrice(2400D);
        order1.setCountry("Kyrgyzstan");
        order1.setCity("Bishkek");
        order1.setOrderDate(new GregorianCalendar(2022, 3, 10).getTime());
        order1.setOrderAddress("Asanbay 40/58");
        order1.setProductId(product);

        String jsonRequest = mapper.writeValueAsString(order1);

        mockMvc.perform(
                        post("/api/v1/orders")
                                .content(jsonRequest)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("Order was added successfully"));

//        MvcResult result = mockMvc.perform(post("http://localhost:8080/api/v1/orders")
//                        .with(httpBasic("admin@gmail.com", "admin"))
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(jsonRequest)
//                        .characterEncoding("utf-8"))
//                .andExpect(status().isOk())
//                .andReturn();
    }
//
//    @Test
//    void updateOrder() {
//    }
//
//    @Test
//    void deleteOrder() {
//    }


}