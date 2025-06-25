package com.mohammadzoubi.microservices.customer.dto.createcustomer.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateCustomerResponse {

    private Long customerId;
    private String name;
    private String email;
    private String phoneNumber;
    private String customerStatus;
}
