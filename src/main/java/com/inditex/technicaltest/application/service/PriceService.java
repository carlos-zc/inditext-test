package com.inditex.technicaltest.application.service;

import com.inditex.technicaltest.domain.entity.Price;
import com.inditex.technicaltest.domain.model.PriceResponse;
import com.inditex.technicaltest.domain.port.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PriceService {
    private final PriceRepository priceRepository;

    // Condicion: Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar,
    // fechas de aplicación y precio final a aplicar
    public PriceResponse getPrice(LocalDateTime date, Long productId, Long brandId) {
        Price price = priceRepository.getPrice(date, productId, brandId).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("No price found for %s product:%d brand:%d ", date, productId, brandId))
        );

        return new PriceResponse(price);
    }

}
