package com.gsk.ecom.model.order;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor@NoArgsConstructor
@Setter@Getter
@Builder
public class Order {

    private Integer id;
    private String reference;
    private Long orderAmount;
    private Integer customerId;
    private PaymentMethod paymentMethod;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

}
