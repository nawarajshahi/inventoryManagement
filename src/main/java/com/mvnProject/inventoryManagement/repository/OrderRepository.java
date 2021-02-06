package com.mvnProject.inventoryManagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.mvnProject.inventoryManagement.entity.Orders;

public interface OrderRepository extends CrudRepository<Orders, Long>{

}
