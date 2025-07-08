package com.mohammadzoubi.microservices.customer.repository;

import com.mohammadzoubi.microservices.customer.dto.getCustomer.response.GetCustomerResponse;
import com.mohammadzoubi.microservices.customer.entity.Customer;
import com.mohammadzoubi.microservices.customer.enums.CustomerStatusEnum;
import com.mohammadzoubi.microservices.customer.repository.projection.GetCustomerProjection;
import com.mohammadzoubi.microservices.customer.repository.projection.GetCustomersProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


    @Query(value = "SELECT name as name," +
            " email as email," +
            " phone_number as phoneNumber," +
            " status as status," +
            " created_at as createdAt" +
            " FROM customer " +
            " WHERE customer_id = :customerId", nativeQuery = true)
    Optional<GetCustomerProjection> getCustomerById(@Param("customerId") Long customerId);

    @Query(value = """
            SELECT customer_id as customerId,
                   name as name,
                   email as email,
                   phone_number as phoneNumber,
                   status as status,
                   created_at as createdAt
            FROM customer
            WHERE (:name IS NULL OR LOWER(name) LIKE CONCAT('%',:name,'%'))
            AND (:phoneNumber IS NULL OR LOWER(phone_number) LIKE CONCAT('%',:phoneNumber,'%'))
            AND (:status IS NULL OR LOWER(status) LIKE CONCAT('%',:status,'%'))
            """, nativeQuery = true)
    Page<GetCustomersProjection> getCustomers(@Param("name") String name,
                                              @Param("phoneNumber") String phoneNumber,
                                              @Param("status") String status,
                                              Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = """ 
            UPDATE customer
            SET
             email = CASE WHEN :email IS NOT NULL THEN :email ELSE email END,
             phone_number = CASE WHEN :phoneNumber IS NOT NULL THEN :phoneNumber ELSE phone_number END 
            WHERE customer_id = :customerId""", nativeQuery = true)
    void updateCustomer(@Param("customerId") Long customerId,
                        @Param("email") String email,
                        @Param("phoneNumber") String phoneNumber);


    @Modifying
    @Transactional
    @Query(value = """ 
            UPDATE customer
            SET
             status = :status
            WHERE customer_id = :customerId""", nativeQuery = true)
    void updateCustomerStatus(@Param("customerId") Long customerId,
                              @Param("status") String status);

//    @Query(value = "SELECT name," +
//            " username," +
//            " email," +
//            " department," +
//            " created_on," +
//            " user_status" +
//            " FROM task_manager.users",nativeQuery = true)
//    Page<GetUserPojo> getUsersList(Pageable pageable);
}
