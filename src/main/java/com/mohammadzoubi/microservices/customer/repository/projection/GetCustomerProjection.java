package com.mohammadzoubi.microservices.customer.repository.projection;

import java.time.LocalDateTime;

public interface GetCustomerProjection {

    String getName();
    String getEmail();
    String getPhoneNumber();
    String getStatus();
    LocalDateTime getCreatedAt();
}
