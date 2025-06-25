package com.mohammadzoubi.microservices.customer.dto.updateustomer.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateCustomerResponse {

    private Long customerId;
    private String name;
    private String email;
    private String phoneNumber;
    private String customerStatus;
}
