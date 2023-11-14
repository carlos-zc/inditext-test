package com.inditex.technicaltest.domain.port;

import com.inditex.technicaltest.domain.entity.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository {
    Optional<Price> getPrice(LocalDateTime date, Long productId, Long brandId);
}
