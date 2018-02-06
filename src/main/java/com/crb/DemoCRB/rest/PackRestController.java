package com.crb.DemoCRB.rest;

import java.util.List;

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

import com.crb.DemoCRB.model.Pack;
import com.crb.DemoCRB.service.PackService;



@RestController
public class PackRestController {

	  	@Autowired
	    PackService packService; 
	 
	
	    //-------------------Retrieve All Packs--------------------------------------------------------
	     
	    @RequestMapping(value = "/pack/", method = RequestMethod.GET)
	    public ResponseEntity<List<Pack>> listAllPacks() {
	        List<Pack> packs = packService.findAllPacks();
	        if(packs.isEmpty()){
	            return new ResponseEntity<List<Pack>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<Pack>>(packs, HttpStatus.OK);
	    }
	 
	 
	    
	    //-------------------Retrieve Single Pack--------------------------------------------------------
	     
	    @RequestMapping(value = "/pack/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Pack> getPack(@PathVariable("id") long id) {
	        System.out.println("Fetching Pack with id " + id);
	        Pack pack = packService.findById(id);
	        if (pack == null) {
	            System.out.println("Pack with id " + id + " not found");
	            return new ResponseEntity<Pack>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Pack>(pack, HttpStatus.OK);
	    }
	 
	     
	     
	    //-------------------Create a Pack--------------------------------------------------------
	     
	    @RequestMapping(value = "/pack/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createPack(@RequestBody Pack pack,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating Pack " + pack.getNumber());
	 
	        if (packService.isPackExist(pack)) {
	            System.out.println("A Pack with name " + pack.getNumber() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	 
	        packService.savePack(pack);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/pack/{id}").buildAndExpand(pack.getId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 
	    
	     
	    //------------------- Update a Pack --------------------------------------------------------
	     
	    @RequestMapping(value = "/pack/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Pack> updatePack(@PathVariable("id") long id, @RequestBody Pack pack) {
	        System.out.println("Updating Pack " + id);
	         
	        Pack currentPack = packService.findById(id);
	         
	        if (currentPack==null) {
	            System.out.println("Pack with id " + id + " not found");
	            return new ResponseEntity<Pack>(HttpStatus.NOT_FOUND);
	        }
	 
	        currentPack.setNumber(pack.getNumber());
	        currentPack.setPrice(pack.getPrice());
	        currentPack.setProfile(pack.getProfile());
	        
	        packService.updatePack(currentPack);
	        return new ResponseEntity<Pack>(currentPack, HttpStatus.OK);
	    }
	 
	    
	    
	    //------------------- Delete a Pack --------------------------------------------------------
	     
	    @RequestMapping(value = "/pack/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Pack> deletePack(@PathVariable("id") long id) {
	        System.out.println("Fetching & Deleting Pack with id " + id);
	 
	        Pack pack = packService.findById(id);
	        if (pack == null) {
	            System.out.println("Unable to delete. Pack with id " + id + " not found");
	            return new ResponseEntity<Pack>(HttpStatus.NOT_FOUND);
	        }
	 
	        packService.deletePackById(id);
	        return new ResponseEntity<Pack>(HttpStatus.NO_CONTENT);
	    }
	 
	     
	    
	    //------------------- Delete All Packs --------------------------------------------------------
	     
	    @RequestMapping(value = "/pack/", method = RequestMethod.DELETE)
	    public ResponseEntity<Pack> deleteAllPacks() {
	        System.out.println("Deleting All Packs");
	 
	        packService.deleteAllPacks();
	        return new ResponseEntity<Pack>(HttpStatus.NO_CONTENT);
	    }
}
