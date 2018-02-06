package com.crb.DemoCRB;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.crb.DemoCRB.model.Pack;
import com.crb.DemoCRB.rest.PackRestController;
import com.crb.DemoCRB.service.PackService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PackRestControllerTests {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
   
	@MockBean
	private PackService packService;
	
	private MockMvc mockMvc;
	private PackRestController packController;
	private ResponseEntity<List> entityAllPacks;
	private List<Pack> packs;
	
	@Before
	public void serUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		packController = new PackRestController();
		packs = new ArrayList<>();
	}
		
	@Test
	public void contextLoads() {
		assertThat(packController).isNotNull();
	}
	
	@Test
	public void testStatusListAllPacks() throws Exception {
		mockMvc.perform(get("/pack")).andExpect(status().isOk())
										.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void testListAllPacks() throws Exception {
		entityAllPacks = new ResponseEntity<List>(packs, HttpStatus.OK);
		assertNotNull(entityAllPacks);
	}
	
	@Test
	public void testPacks() throws Exception {
		Pack pack = new Pack(2, 20, "2", "Rent by Day");
		//when(packService.findById(1).thenReturn(true);
		mockMvc.perform(get("/pack/2")).andExpect(status().is2xxSuccessful())
											.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
											.andDo(MockMvcResultHandlers.print());
		//verify(packService, times(1)).;
		//verifyNoMoreInteractions(packService);
	}
	
	@Test
	public void testUpdateCustomer() throws Exception {
		Pack pack = new Pack(2, 20, "2", "Rental by Day");
		when(packService.findById(2)).thenReturn(pack);
		doNothing().when(packService).updatePack(pack);
		
		mockMvc.perform(put("/pack/2")).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
										.andExpect(status().isOk());
		
		verify(packService, times(1)).findById(pack.getId());
		verify(packService, times(1)).updatePack(pack);
		verifyNoMoreInteractions(packService);
		
	}
	

}
