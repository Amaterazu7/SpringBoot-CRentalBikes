package com.crb.DemoCRB.service;

import java.util.List;

import com.crb.DemoCRB.model.Customer;

public interface CustomerService {
	Customer findById(long id);
	
	Customer findByName(String name);
	
	void saveCustomer(Customer customer);
	
	void updateCustomer(Customer customer);
	
	void deleteCustomerById(long id);

	List<Customer> findAllCustomers();
	
	void deleteAllCustomers();
	
	public boolean isCustomerExist(Customer customer);
}
