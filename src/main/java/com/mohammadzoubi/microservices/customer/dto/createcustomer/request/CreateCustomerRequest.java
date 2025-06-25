package com.mohammadzoubi.microservices.customer.dto.createcustomer.request;

import com.mohammadzoubi.microservices.customer.config.SystemConfig;
import com.mohammadzoubi.microservices.customer.config.SystemMessages;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateCustomerRequest {

    @NotBlank(message = SystemMessages.CUSTOMER_NAME_NOT_BLANK_MESSAGE)
    @Size(max = SystemConfig.CUSTOMER_NAME_MAX_SIZE,
            message = SystemMessages.CUSTOMER_NAME_MAX_SIZE_MESSAGE)
    private String name;
    @Email(message = SystemMessages.INVALID_EMAIL_MESSAGE)
    private String email;
    @Size(max = SystemConfig.PHONE_NUMBER_MAX_SIZE)
    private String phoneNumber;
}
