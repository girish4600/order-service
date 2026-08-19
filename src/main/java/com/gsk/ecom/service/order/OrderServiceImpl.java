package com.gsk.ecom.service.order;

import com.gsk.ecom.handler.order.BusinessException;
import com.gsk.ecom.model.order.OrderRequest;
import com.gsk.ecom.outer_api.order.CustomerService;
import com.gsk.ecom.outer_api.order.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Override
    public String placeOrder(OrderRequest orderRequest) {
        var custId = orderRequest.customerId();
        log.info("fetch customer from orderRequest {}", custId);
        var customer = customerService.findById(custId).orElseThrow(() -> new BusinessException(String.format("Unable to Create Order :: CustomerNotFound for customerId :: %d", custId)));
        System.out.println("Customer :: " + customer);
        log.info("======================== Calling purchaseProduct ========================");
        var purchaseList = productService.purchaseProduct(orderRequest.purchaseRequests());
        log.info("======================== completed purchaseProduct ========================");
        return "success";
    }
}
