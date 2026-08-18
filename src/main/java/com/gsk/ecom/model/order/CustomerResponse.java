package com.gsk.ecom.model.order;

import lombok.*;

@Setter@Getter
@AllArgsConstructor@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class CustomerResponse {
    private Integer customerId;
    private String customerName;
    private String customerLastName;
    private String customerAddress;

}
