package com.mvnProject.inventoryManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mvnProject.inventoryManagement.entity.Product;
import com.mvnProject.inventoryManagement.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getProducts(){
		return new ResponseEntity<Object>(service.getProducts(), HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> creatProduct(@RequestBody Product product){
		return new ResponseEntity<Object>(service.createProduct(product), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method= RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@RequestBody Product product, @PathVariable Long id){
		try {
			return new ResponseEntity<Object>(service.updateProduct(product, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to updat the product. ", HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delteProduct(@PathVariable Long id){
		try {
			service.removeProduct(id);
			return new ResponseEntity<Object>("Successfully deleted the product with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to delete the product. ", HttpStatus.BAD_REQUEST);
		}
	}
	

}
