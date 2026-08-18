package com.gsk.ecom.service.order;

import com.gsk.ecom.model.order.OrderRequest;
import com.gsk.ecom.outer_api.order.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CustomerService customerService;

    @Override
    public String placeOrder(OrderRequest orderRequest) {
        log.info("fetch customer from orderRequest {}", orderRequest.customerId());
        var customer = customerService.findById(orderRequest.customerId());
        System.out.println("Customer :: " + customer);
        return "success";
    }
}
