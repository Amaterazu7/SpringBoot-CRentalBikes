package com.crb.DemoCRB;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.crb.DemoCRB.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoCrbApplicationTests {

	@Autowired
	private DemoCrbApplication demoCrb;
	
	@Test
	public void contextLoads() {
		assertThat(demoCrb).isNotNull();
	}

}
