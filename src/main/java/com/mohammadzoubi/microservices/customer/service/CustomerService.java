package com.mohammadzoubi.microservices.customer.service;

import com.mohammadzoubi.microservices.customer.config.ErrorMessages;
import com.mohammadzoubi.microservices.customer.config.SystemConfig;
import com.mohammadzoubi.microservices.customer.dto.createcustomer.request.CreateCustomerRequest;
import com.mohammadzoubi.microservices.customer.dto.createcustomer.response.CreateCustomerResponse;
import com.mohammadzoubi.microservices.customer.dto.getCustomer.response.GetCustomerResponse;
import com.mohammadzoubi.microservices.customer.dto.getcustomers.response.GetAllCustomersResponse;
import com.mohammadzoubi.microservices.customer.dto.updateustomer.request.UpdateCustomerRequest;
import com.mohammadzoubi.microservices.customer.entity.Customer;
import com.mohammadzoubi.microservices.customer.enums.CustomerStatusEnum;
import com.mohammadzoubi.microservices.customer.exception.ResourceNotFoundException;
import com.mohammadzoubi.microservices.customer.repository.CustomerRepository;
import com.mohammadzoubi.microservices.customer.repository.projection.GetCustomerProjection;
import com.mohammadzoubi.microservices.customer.repository.projection.GetCustomersProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CreateCustomerResponse createCustomer(final CreateCustomerRequest createCustomerRequest) {

        Customer newCustomer = Customer.builder()
                .name(createCustomerRequest.getName())
                .email(createCustomerRequest.getEmail())
                .phoneNumber(createCustomerRequest.getPhoneNumber())
                .status(CustomerStatusEnum.ACTIVE)
                .build();

        newCustomer = customerRepository.save(newCustomer);

        return CreateCustomerResponse.builder()
                .customerId(newCustomer.getCustomerId())
                .name(newCustomer.getName())
                .email(newCustomer.getEmail())
                .phoneNumber(newCustomer.getPhoneNumber())
                .customerStatus(newCustomer.getStatus().name())
                .build();

    }

    public GetAllCustomersResponse getAllCustomers(
            final Integer pageNumber,
            final Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNumber,
                pageSize,
                Sort.by(Sort.Direction.DESC,
                        SystemConfig.DEFAULT_CUSTOMER_SORTING));

        Page<GetCustomersProjection> customersProjection = customerRepository.getCustomers(pageable);

        return GetAllCustomersResponse.builder()
                .customers(GetAllCustomersResponse.mapper(customersProjection))
                .build();
    }

    public GetCustomerResponse getCustomerById(final Long customerId) {
        final GetCustomerProjection customerProjection =
                customerRepository.getCustomerById(customerId).orElseThrow(
                        () -> new ResourceNotFoundException(ErrorMessages.CUSTOMER_NOT_FOUND_ERROR_MESSAGE));

        return GetCustomerResponse.builder()
                .name(customerProjection.getName())
                .email(customerProjection.getEmail())
                .phoneNumber(customerProjection.getPhoneNumber())
                .status(customerProjection.getStatus())
                .createdAt(customerProjection.getCreatedAt())
                .build();
    }

    public void updateCustomerById(
            final Long customerId,
            final UpdateCustomerRequest updateCustomerRequest) {

        customerRepository.updateCustomer(customerId,
                updateCustomerRequest.getEmail(),
                updateCustomerRequest.getPhoneNumber());

    }

    public void activateCustomer(final Long customerId) {
        customerRepository.updateCustomerStatus(customerId, CustomerStatusEnum.ACTIVE.name());
    }

    public void deactivateCustomer(final Long customerId) {
        customerRepository.updateCustomerStatus(customerId, CustomerStatusEnum.INACTIVE.name());
    }

    public void deleteCustomer(final Long customerId) {
        customerRepository.updateCustomerStatus(customerId, CustomerStatusEnum.DELETED.name());

    }


}
