package com.mvnProject.inventoryManagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.mvnProject.inventoryManagement.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
