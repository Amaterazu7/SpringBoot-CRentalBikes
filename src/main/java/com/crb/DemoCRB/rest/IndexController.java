package com.crb.DemoCRB.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String getIndexPage(){
		return "IndexManagement";
	}
	
	@RequestMapping("/pack")
	public String getPackPage(){
		return "PackManagement";
	}
	
	@RequestMapping("/customer")
	public String getCustomerPage(){
		return "CustomerManagement";
	}
}
