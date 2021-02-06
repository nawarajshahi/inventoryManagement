package com.mvnProject.inventoryManagement.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvnProject.inventoryManagement.entity.Customer;
import com.mvnProject.inventoryManagement.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private static final Logger logger = LogManager.getLogger(CustomerService.class);
	
	@Autowired
	private CustomerRepository repo;
	
	public Customer getCustomerById(Long id) throws Exception{
		try {
			return repo.findOne(id);
		} catch(Exception e) {
			logger.error("Exception occured while trying retrieve customer" + id, e);
			throw e;
		}
	}
	
	public Iterable<Customer> getCustomers(){
		return repo.findAll();
	}
	
	public Customer createCustomer(Customer customer) {
		return repo.save(customer);
	}
	
	public Customer updateCustomer(Customer customer, Long id) throws Exception{
		try {
			Customer oldCustomer = repo.findOne(id);
			oldCustomer.setAddress(customer.getAddress());
			oldCustomer.setFirstName(customer.getFirstName());
			oldCustomer.setLastName(customer.getLastName());
			oldCustomer.setLevel(customer.getLevel());
			logger.info("WOrking or not????");
			return repo.save(oldCustomer);
		}catch(Exception e) {
			logger.error("Exception occured while trying to update the customer" + id, e);
			throw new Exception("Unable to update the customer");
		}
	}
	
	public void deleteCustomer(Long id) throws Exception{
		try {
			repo.delete(id);
		} catch(Exception e) {
			logger.error("Exception occured while trying to delete the customer" + id, e);
			throw new Exception("Unable to delete the customer.");
		}
		
	}

}
