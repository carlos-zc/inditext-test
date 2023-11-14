package com.inditex.technicaltest.infrastructure.repository;

import com.inditex.technicaltest.domain.entity.Price;
import com.inditex.technicaltest.domain.port.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PriceRepositoryImpl implements PriceRepository {
    private final PriceRepositoryH2 priceRepository;

    @Override
    public Optional<Price> getPrice(LocalDateTime date, Long productId, Long brandId) {
        return priceRepository.findPriceByDateAndProductAndBrand(date, productId, brandId);
    }
}
