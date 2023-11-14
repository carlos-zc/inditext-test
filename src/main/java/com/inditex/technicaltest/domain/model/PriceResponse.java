package com.inditex.technicaltest.domain.model;

import com.inditex.technicaltest.domain.entity.Price;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class PriceResponse {
    private Long productId;
    private Long brandId;
    private Long priceId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double price;

    public PriceResponse(Price price) {
        this.productId = price.getProduct().getId();
        this.brandId = price.getBrand().getId();
        this.priceId = price.getPriceList();
        this.startDate = price.getStartDate();
        this.endDate = price.getEndDate();
        this.price = price.getPrice();
    }
}
