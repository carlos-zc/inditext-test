package com.inditex.technicaltest.infrastructure.repository;

import com.inditex.technicaltest.domain.entity.Price;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepositoryH2 extends Repository<Price, Long> {
    @Query("SELECT p FROM Price p WHERE ?1 BETWEEN p.startDate AND p.endDate AND p.product.id = ?2 AND p.brand.id = ?3 " +
            "ORDER BY p.priority DESC LIMIT 1")
    Optional<Price> findPriceByDateAndProductAndBrand(LocalDateTime date, Long productId, Long brandId);
}
