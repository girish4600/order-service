package com.gsk.ecom.service.order;

import com.gsk.ecom.handler.order.BusinessException;
import com.gsk.ecom.mapper.order.OrderMapper;
import com.gsk.ecom.model.order.Order;
import com.gsk.ecom.model.order.OrderRequest;
import com.gsk.ecom.model.payment.PaymentRequest;
import com.gsk.ecom.outer_api.order.CustomerService;
import com.gsk.ecom.outer_api.order.PaymentService;
import com.gsk.ecom.outer_api.order.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final Map<Integer, Order> orders;
    private static Integer orderId = 1;

    OrderServiceImpl() {
        orders = new HashMap<>();
    }

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private OrderMapper mapper;

    @Override
    public String placeOrder(OrderRequest orderRequest) {
        var custId = orderRequest.customerId();
        log.info("fetch customer from orderRequest {}", custId);
        var customer = customerService.findById(custId).orElseThrow(() -> new BusinessException(String.format("Unable to Create Order :: CustomerNotFound for customerId :: %d", custId)));
        System.out.println("Customer :: " + customer);
        log.info("======================== Calling purchaseProduct ========================");
        log.info("purchaseRequest :: {}", orderRequest.purchaseRequests());
        var purchaseList = productService.purchaseProduct(orderRequest.purchaseRequests());
        log.info("======================== completed purchaseProduct ======================== \n PURCHASE LIST {} \n ======================== ",purchaseList);

        var order = orders.put(orderId++, mapper.dtoToOrderEntity(orderRequest, orderId));
        var paymentRequest = new PaymentRequest(
                orderRequest.amount(),
                orderRequest.paymentMethod(),
                order.getId(),
                order.getReference(),
                customer
        );
        //start payment process
        log.info("======================== Calling payment creation ========================");
        paymentService.createPayment(paymentRequest);
        log.info("======================== payment creation completed ========================");

        return "success";
    }
}
