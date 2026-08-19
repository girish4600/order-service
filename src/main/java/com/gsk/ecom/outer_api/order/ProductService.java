package com.gsk.ecom.outer_api.order;

import com.gsk.ecom.handler.order.BusinessException;
import com.gsk.ecom.model.order.ProductPurchaseRequest;
import com.gsk.ecom.model.order.ProductPurchaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
//        httpHeaders.set(CONTENT_TYPE, APPLICATION_JSON_VALUE);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<List<ProductPurchaseRequest>> requestEntity = new HttpEntity<>(purchaseRequest, httpHeaders);
        System.out.println("productUrl :: "+ productUrl+"/v1/product/purchase");
        log.info("purchaseRequest in order service :: {}", purchaseRequest);
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
