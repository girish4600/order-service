package com.gsk.ecom.outer_api.order;

import com.gsk.ecom.handler.order.BusinessException;
import com.gsk.ecom.model.order.CustomerResponse;
import com.gsk.ecom.model.order.ProductPurchaseRequest;
import com.gsk.ecom.model.order.ProductPurchaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
@Slf4j
public class ProductService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${application.config.product-url:http://product-service:8080}")
    private String productUrl;


    public List<ProductPurchaseResponse> purchaseProduct(List<ProductPurchaseRequest> purchaseRequest) {
        log.info("ProductService purchaseProduct");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(CONTENT_TYPE, APPLICATION_JSON_VALUE);
        HttpEntity<List<ProductPurchaseRequest>> requestEntity = new HttpEntity<>(purchaseRequest, httpHeaders);
        System.out.println("productUrl :: "+ productUrl);
        ParameterizedTypeReference<List<ProductPurchaseResponse>> responseType = new ParameterizedTypeReference<List<ProductPurchaseResponse>>() {};
        ResponseEntity<List<ProductPurchaseResponse>> responseEntity =  restTemplate.exchange(productUrl+"/v1/product/purchase",
                HttpMethod.POST,
                requestEntity,
                responseType
        );
        log.info("responseEntity :: {}", responseEntity.getBody());
        if(responseEntity.getStatusCode().isError()){
            throw new BusinessException("Error occurred while processing products" + responseEntity.getStatusCode());
        }
        return responseEntity.getBody();
    }
}
