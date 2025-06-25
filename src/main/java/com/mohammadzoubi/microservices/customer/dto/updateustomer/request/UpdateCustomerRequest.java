package com.mohammadzoubi.microservices.customer.dto.updateustomer.request;

import com.mohammadzoubi.microservices.customer.config.SystemConfig;
import com.mohammadzoubi.microservices.customer.config.SystemMessages;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateCustomerRequest {

    @Email(message = SystemMessages.INVALID_EMAIL_MESSAGE)
    private String email;
    @Size(max = SystemConfig.PHONE_NUMBER_MAX_SIZE)
    private String phoneNumber;
}
