package com.gsk.ecom.controller.order;

import com.gsk.ecom.model.order.OrderRequest;
import com.gsk.ecom.service.order.OrderService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/order")
@Slf4j
public class OrderServiceController {

    @Resource
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequest orderRequest){
        log.info("inside controller placing order : {}",orderRequest);
        var response = orderService.placeOrder(orderRequest);
        return ResponseEntity.ok(response);
    }
}
