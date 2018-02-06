package com.crb.DemoCRB.repository;

import org.springframework.data.repository.CrudRepository;

import com.crb.DemoCRB.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	Customer findByName(String name);
}