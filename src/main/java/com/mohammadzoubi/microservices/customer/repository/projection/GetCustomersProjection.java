package com.mohammadzoubi.microservices.customer.repository.projection;

import java.time.LocalDateTime;

public interface GetCustomersProjection {

    Long getCustomerId();
    String getName();
    String getEmail();
    String getPhoneNumber();
    String getStatus();
    LocalDateTime getCreatedAt();
}
