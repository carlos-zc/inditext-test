package com.inditex.technicaltest.infrastructure.controller;

import com.inditex.technicaltest.application.service.PriceService;
import com.inditex.technicaltest.domain.model.PriceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/prices")
@RequiredArgsConstructor
public class PriceController {
    private final PriceService priceService;

    // Condicion: Acepte como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena
    @GetMapping
    public ResponseEntity<PriceResponse> getPrice(
        @RequestParam LocalDateTime date,
        @RequestParam Long productId,
        @RequestParam Long brandId
    ) {
        PriceResponse priceResponse = priceService.getPrice(date, productId, brandId);

        return ResponseEntity.ok(priceResponse);
    }
}
