package com.inditex.technicaltest.infrastructure.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private void performRequest(LocalDateTime date, Long productId, Long brandId) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/prices")
                .param("date", date.toString())
                .param("productId", Long.toString(productId))
                .param("brandId", Long.toString(brandId))
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(productId))
            .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(brandId))
            .andExpect(MockMvcResultMatchers.jsonPath("$.priceId").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.price").exists());
    }

    // Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    void test1() throws Exception {
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 10,0);
        performRequest(date, 35455L, 1L);
    }

    // Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    void test2() throws Exception {
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 16,0);
        performRequest(date, 35455L, 1L);
    }

    // Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    void test3() throws Exception {
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 21,0);
        performRequest(date, 35455L, 1L);
    }

    // Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
    @Test
    void test4() throws Exception {
        LocalDateTime date = LocalDateTime.of(2020, 6, 15, 10,0);
        performRequest(date, 35455L, 1L);
    }

    // Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
    @Test
    void test5() throws Exception {
        LocalDateTime date = LocalDateTime.of(2020, 6, 16, 21,0);
        performRequest(date, 35455L, 1L);
    }

    @Test
    void testNotFound() throws Exception {
        LocalDateTime date = LocalDateTime.of(2020, 6, 16, 21,0);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/prices")
                .param("date", date.toString())
                .param("productId", "35455")
                .param("brandId", "2") // Incorrect ID
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isNotFound());
    }
}