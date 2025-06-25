package com.mohammadzoubi.microservices.customer.dto.getCustomer.response;

import com.mohammadzoubi.microservices.customer.enums.CustomerStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class GetCustomerResponse {

    private String name;
    private String email;
    private String phoneNumber;
    private String status;
    private LocalDateTime createdAt;

}
