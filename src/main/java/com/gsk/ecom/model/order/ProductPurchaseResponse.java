package com.gsk.ecom.model.order;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductPurchaseResponse(

        Integer id,
        String productName,
        Integer quantity,
        BigDecimal price
) {
}
