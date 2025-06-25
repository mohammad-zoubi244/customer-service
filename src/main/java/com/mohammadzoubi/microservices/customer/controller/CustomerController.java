package com.mohammadzoubi.microservices.customer.controller;

import com.mohammadzoubi.microservices.customer.config.SystemConfig;
import com.mohammadzoubi.microservices.customer.dto.createcustomer.request.CreateCustomerRequest;
import com.mohammadzoubi.microservices.customer.dto.createcustomer.response.CreateCustomerResponse;
import com.mohammadzoubi.microservices.customer.dto.getCustomer.response.GetCustomerResponse;
import com.mohammadzoubi.microservices.customer.dto.getcustomers.response.GetAllCustomersResponse;
import com.mohammadzoubi.microservices.customer.dto.updateustomer.request.UpdateCustomerRequest;
import com.mohammadzoubi.microservices.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping()
    public ResponseEntity<CreateCustomerResponse> createCustomer(
            @RequestBody @Valid final CreateCustomerRequest createCustomerRequest) {

        final CreateCustomerResponse response = customerService.createCustomer(createCustomerRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping
    public ResponseEntity<GetAllCustomersResponse> getAllCustomers(
            @RequestParam(name = "page-number",
                    defaultValue = SystemConfig.DEFAULT_PAGE_NUMBER,
                    required = false) final Integer pageNumber,
            @RequestParam(name = "page-size",
                    defaultValue = SystemConfig.DEFAULT_PAGE_SIZE,
                    required = false) final Integer pageSize
    ) {

        final GetAllCustomersResponse customers = customerService.getAllCustomers(pageNumber, pageSize);

        return ResponseEntity.status(HttpStatus.OK).body(customers);

    }

    @GetMapping("/{customerId}")
    public ResponseEntity<GetCustomerResponse> getCustomerById(
            @PathVariable(name = "customerId") final Long customerId) {

        final GetCustomerResponse customer = customerService.getCustomerById(customerId);

        return ResponseEntity.status(HttpStatus.OK).body(customer);

    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Void> updateCustomer(
            @PathVariable(name = "customerId") final Long customerId,
            @RequestBody @Valid final UpdateCustomerRequest updateCustomerRequest
    ) {

        customerService.updateCustomerById(customerId, updateCustomerRequest);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{customerId}/activate")
    public ResponseEntity<Void> activateCustomer(
            @PathVariable(name = "customerId") final Long customerId) {

        customerService.activateCustomer(customerId);

        return ResponseEntity.noContent().build();

    }

    @PatchMapping("/{customerId}/deactivate")
    public ResponseEntity<Void> deactivateCustomer(
            @PathVariable(name = "customerId") final Long customerId) {

        customerService.deactivateCustomer(customerId);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(
            @PathVariable(name = "customerId") final Long customerId) {

        customerService.deleteCustomer(customerId);

        return ResponseEntity.noContent().build();

    }

}
