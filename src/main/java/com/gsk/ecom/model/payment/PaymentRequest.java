package com.gsk.ecom.model.payment;

import com.gsk.ecom.model.order.CustomerResponse;
import com.gsk.ecom.model.order.PaymentMethod;
import lombok.Builder;

@Builder
public record PaymentRequest(
        Long amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer

) {
}
