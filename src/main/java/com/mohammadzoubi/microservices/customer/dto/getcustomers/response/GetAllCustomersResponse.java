package com.mohammadzoubi.microservices.customer.dto.getcustomers.response;

import com.mohammadzoubi.microservices.customer.repository.projection.GetCustomersProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class GetAllCustomersResponse {

    private List<CustomerDetails> customers;

    public static List<CustomerDetails> mapper(final Page<GetCustomersProjection> getCustomersProjections) {
        List<CustomerDetails> customers = new ArrayList<>();

        getCustomersProjections.forEach(
                pojo -> {
                    CustomerDetails customerDetails = CustomerDetails.builder()
                            .customerId(pojo.getCustomerId())
                            .name(pojo.getName())
                            .email(pojo.getEmail())
                            .phoneNumber(pojo.getPhoneNumber())
                            .createdAt(pojo.getCreatedAt())
                            .status(pojo.getStatus())
                            .build();

                    customers.add(customerDetails);
                }
        );

        return customers;
    }
}
