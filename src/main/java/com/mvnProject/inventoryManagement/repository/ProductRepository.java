package com.mvnProject.inventoryManagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.mvnProject.inventoryManagement.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
