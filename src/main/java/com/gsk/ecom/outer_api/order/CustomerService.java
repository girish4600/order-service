package com.gsk.ecom.outer_api.order;

import com.gsk.ecom.model.order.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
@FeignClient(name = "customer-service", url = "http://customer-service:8080")
public interface CustomerService {
    @GetMapping("/v1/customer/{customerId}")
    Optional<CustomerResponse> findById(@PathVariable("customerId") Integer customerId);
}
