package com.gsk.ecom.kafka.model;


import com.gsk.ecom.model.order.CustomerResponse;
import com.gsk.ecom.model.order.PaymentMethod;
import com.gsk.ecom.model.order.ProductPurchaseResponse;
import lombok.Builder;

import java.util.List;

@Builder
public record OrderNotificationRequest(
        Integer id,
        String reference,
        PaymentMethod paymentMethod,
        Long amount,
        CustomerResponse customer,
        List<ProductPurchaseResponse> products
) {
}
