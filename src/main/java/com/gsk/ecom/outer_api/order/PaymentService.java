package com.gsk.ecom.outer_api.order;


import com.gsk.ecom.model.payment.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient( name = "payment-service", url = "${application.config.payment-url:http://payment-service:8080}")
public interface PaymentService {

    @PostMapping("/v1/payment")
    public ResponseEntity<Integer> createPayment(@RequestBody PaymentRequest paymentRequest);
}
