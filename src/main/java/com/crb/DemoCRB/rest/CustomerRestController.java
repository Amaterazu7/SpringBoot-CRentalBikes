package com.crb.DemoCRB.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.crb.DemoCRB.model.Customer;
import com.crb.DemoCRB.model.Pack;
import com.crb.DemoCRB.service.CustomerService;
import com.crb.DemoCRB.service.PackService;



@RestController
public class CustomerRestController {

	  	@Autowired
	    CustomerService customerService;
	  	@Autowired
	    PackService packService;
	    
	    //-------------------Retrieve All Customers--------------------------------------------------------
	     
		@RequestMapping(value = "/customer/", method = RequestMethod.GET)
	    public ResponseEntity<Map<String, List>> listAllCustomers() {
			List<Pack> packs = packService.findAllPacks();
	        List<Customer> customers = customerService.findAllCustomers();
	    	
	        HashMap<String, List>hashMap = new HashMap<>();
	    	hashMap.put("Customer", customers);
	    	hashMap.put("Pack", packs);
	    	
	        if(customers.isEmpty()&&packs.isEmpty()){
	            return new ResponseEntity<Map<String, List>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<Map<String, List>>(hashMap, HttpStatus.OK);
	    }

	     
	    //-------------------Retrieve Single Customer--------------------------------------------------------
	     
	    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id) {
	        System.out.println("Fetching Customer with id " + id);
	        Customer customer = customerService.findById(id);
	        if (customer == null) {
	            System.out.println("Customer with id " + id + " not found");
	            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	    }
	    
	    
	     
	    //-------------------Create a Customer--------------------------------------------------------
	     
	    @RequestMapping(value = "/customer/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer, UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating Customer " + customer.getName());
	 
	        if (customerService.isCustomerExist(customer)) {
	            System.out.println("A Customer with name " + customer.getName() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	        if(customer.isBenefits()) {customer=addBenefits(customer);}
	        customerService.saveCustomer(customer);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/customer/{id}").buildAndExpand(customer.getId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	    
	    public Customer addBenefits(Customer customer){
	    	float disc = (float) (customer.getDiscount());
	    	disc = (float) (disc/100)*customer.getPrice();
			float finalPrice = (float)(customer.getPrice()-disc);
			customer.setPrice((int)finalPrice);
			
	    	return customer;
	    }
	     
	    //------------------- Update a Customer --------------------------------------------------------
	     
	    @RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
	        System.out.println("Updating Customer " + id);
	         
	        Customer currentCustomer = customerService.findById(id);
	         
	        if (currentCustomer==null) {
	            System.out.println("Customer with id " + id + " not found");
	            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	        }
	        
	        if(customer.isBenefits()) {customer=addBenefits(customer);}
	        currentCustomer.setName(customer.getName());
	        currentCustomer.setDni(customer.getDni());
	        currentCustomer.setPack(customer.getPack());
	        currentCustomer.setSumBikes(customer.getSumBikes());
	        currentCustomer.setBenefits(customer.isBenefits());
	        currentCustomer.setDiscount(customer.getDiscount());
	        currentCustomer.setPrice(customer.getPrice());
	        currentCustomer.setStartDate(customer.getStartDate());
	        
	        customerService.updateCustomer(currentCustomer);
	        return new ResponseEntity<Customer>(currentCustomer, HttpStatus.OK);
	    }
	 
	    
	    
	    //------------------- Delete a Customer --------------------------------------------------------
	     
	    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") long id) {
	        System.out.println("Fetching & Deleting Customer with id " + id);
	 
	        Customer customer = customerService.findById(id);
	        if (customer == null) {
	            System.out.println("Unable to delete. Customer with id " + id + " not found");
	            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	        }
	 
	        customerService.deleteCustomerById(id);
	        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
	    }
	 
	     
	    
	    //------------------- Delete All Customers --------------------------------------------------------
	     
	    @RequestMapping(value = "/customer/", method = RequestMethod.DELETE)
	    public ResponseEntity<Customer> deleteAllCustomers() {
	        System.out.println("Deleting All Customers");
	 
	        customerService.deleteAllCustomers();
	        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
	    }
	    
}
