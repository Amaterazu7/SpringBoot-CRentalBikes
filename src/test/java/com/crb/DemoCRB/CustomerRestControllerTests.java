package com.crb.DemoCRB;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.AssertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.crb.DemoCRB.model.Customer;
import com.crb.DemoCRB.model.Pack;
import com.crb.DemoCRB.rest.CustomerRestController;
import com.crb.DemoCRB.service.CustomerService;
import com.crb.DemoCRB.service.CustomerServiceImpl;
import com.crb.DemoCRB.service.PackService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRestControllerTests {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private CustomerService customerService;
	
	private MockMvc mockMvc;
	private CustomerRestController customerController;
	
	@Before
	public void serUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		customerController = new CustomerRestController();
	}
		
	@Test
	public void contextLoads() {
		assertThat(customerController).isNotNull();
	}
	
	@Test
	public void testStatusListAllCustomers() throws Exception {
		mockMvc.perform(get("/customer")).andExpect(status().isOk())
											.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void tesFindAllCustomers() throws Exception {
		List<Customer> customers = customerService.findAllCustomers();
		assertNotNull("Failure - expect no null.", customers);
	}
	
	@Test
	public void testGetCustomer() throws Exception {
		mockMvc.perform(get("/customer/2")).andExpect(status().is2xxSuccessful())
											.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
											.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void testDeleteCustomer() throws Exception {
		mockMvc.perform(delete("/customer/2")).andExpect(status().is2xxSuccessful())
											.andDo(MockMvcResultHandlers.print());
		
	}

	@Test
	public void testDeleteAllCustomers() throws Exception {
		mockMvc.perform(delete("/customer/")).andExpect(status().is2xxSuccessful())
											.andDo(MockMvcResultHandlers.print());
		
	}
	
	@Test
	public void testAddBenefits(){
		Date day = new Date(2018, 02, 10);
		Pack pack = new Pack(2, 20,"2","Rental by Day" );
		Customer customer = new Customer(2, "Diego Crescini", 34963658, pack, 5, true, 30, 100, day);
		
		Customer customerWBenefits = customerController.addBenefits(customer);
		float disc = (float) (customer.getDiscount());
		disc = (float) (disc/100)*customer.getPrice();
		float finalPrice = (float) (customer.getPrice()-disc);
		customer.setPrice((int)finalPrice);
		customer.setPrice((int)finalPrice);
		
		assertThat(customerWBenefits.getPrice()).isEqualTo(customer.getPrice());
	}
	
}
