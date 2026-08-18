package com.gsk.ecom.model.order;

import lombok.Builder;

import java.util.List;

@Builder
public record OrderRequest(
        Integer id,
        String reference,
        PaymentMethod paymentMethod,
        Long amount,
        Integer customerId,
        List<ProductPurchaseRequest> purchaseRequests
) {
}
