package com.crb.DemoCRB.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crb.DemoCRB.model.Customer;
import com.crb.DemoCRB.repository.CustomerRepository;
import com.crb.DemoCRB.repository.PackRepository;


@Service("costumerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Customer> customers;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> findAllCustomers() {
		return (List<Customer>) customerRepository.findAll();
	}
		
	@Override
	public Customer findById(long id) {
		return customerRepository.findOne(id);
	}

	@Override
	public Customer findByName(String name) {
		return customerRepository.findByName(name);
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public void deleteCustomerById(long id) {
		customerRepository.delete(id);
	}

	@Override
	public boolean isCustomerExist(Customer customer) {
		return findByName(customer.getName())!=null;
	}
	
	@Override
	public void deleteAllCustomers() {
		customerRepository.deleteAll();
	}


}
