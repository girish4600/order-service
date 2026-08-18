package com.gsk.ecom.model.order;

import lombok.Builder;

@Builder
public record ProductPurchaseRequest(
        Integer productId,
        Integer quantity
) {
}
