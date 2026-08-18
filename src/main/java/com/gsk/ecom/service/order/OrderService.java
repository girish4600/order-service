package com.gsk.ecom.service.order;

import com.gsk.ecom.model.order.OrderRequest;

public interface OrderService {
    String placeOrder(OrderRequest orderRequest);
}
