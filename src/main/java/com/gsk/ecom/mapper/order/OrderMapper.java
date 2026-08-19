package com.gsk.ecom.mapper.order;

import com.gsk.ecom.model.order.Order;
import com.gsk.ecom.model.order.OrderRequest;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderMapper {
    public Order dtoToOrderEntity(OrderRequest orderRequest) {
        return Order.builder()
                .customerId(orderRequest.customerId())
                .orderAmount(orderRequest.amount())
                .paymentMethod(orderRequest.paymentMethod())
                .build();
    }
}
