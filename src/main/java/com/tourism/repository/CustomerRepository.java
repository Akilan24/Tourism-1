package com.tourism.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
