package com.cg.sprint1_onlineplantnursery.controller;

import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.sprint1_onlineplantnursery.entity.Planter;
import com.cg.sprint1_onlineplantnursery.service.IPlanterService;

@RestController
public class IPlanterController extends WebSecurityConfigurerAdapter {

	@Autowired
	private IPlanterService planterService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       super.configure(http);
       http.csrf().disable();
    }
	
    //CUSTOMER CAN PLACE CHOICE AND ADMIN CAN ADD
	@PostMapping("/planter")
	public ResponseEntity<Planter> addPlanter(@Valid @RequestBody Planter planter) {
		planter =  planterService.addPlanter(planter);
			return new ResponseEntity<Planter>(planter,HttpStatus.CREATED);
	}
	
	//BOTH CUSTOMER AND ADMIN
	@GetMapping("/planters")
	public ResponseEntity<List<Planter>> getAllPlanters(){
		List<Planter> planters = planterService.viewAllPlanters();
		return new ResponseEntity<List<Planter>>(planters,HttpStatus.OK);
	}
	
	//BOTH CUSTOMER AND ADMIN
	@GetMapping("/planterById/{id}")
	public ResponseEntity<Planter> getPlanterById(@PathVariable int id) {
		Planter planter = planterService.viewPlanter(id);
		return new ResponseEntity<Planter>(planter,HttpStatus.OK); 
	}
	
	//CUSTOMER CAN PLACE CHOICE AND ADMIN CAN UPDATE
	@PutMapping("/planter")
	public ResponseEntity<Planter> update(@RequestBody Planter planter) {
		Planter newPlanter =  planterService.updatePlanter(planter);
		return new ResponseEntity<Planter>(newPlanter,HttpStatus.OK);
	}
	
	//WHEN CUSTOMER BUYS OR ADMIN WANTS TO DELETE IF IT'S DESTROYED
	@DeleteMapping("/planter")
	public ResponseEntity<Planter> delete(@RequestBody Planter planter) {
		planter =  planterService.deletePlanter(planter);
		return new ResponseEntity<Planter>(planter,HttpStatus.OK);
		
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Planter> partialUpdate(@RequestBody Map<Object, Object> fields, @PathVariable int id){
		return new ResponseEntity<Planter>(planterService.partialUpdate(fields, id), HttpStatus.OK);
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//WHEN CUSTOMER BUYS THE ENTIRE STOCK OR ADMIN NO MORE WANTS TO SELL THAT ITEM
	@DeleteMapping("/planters/deleteStock/{id}")
	public ResponseEntity<Planter> deleteEntireStock(@PathVariable int id) {
		Planter planter =  planterService.deleteEntireStock(id);
		return new ResponseEntity<Planter>(planter,HttpStatus.OK);
	}
	
	@GetMapping("/planters/{min}/{max}")
	public ResponseEntity<List<Planter>> getAllPlantersInRange(@PathVariable double min, @PathVariable double max ){
		List<Planter> planters = planterService.viewAllPlanters(min, max);
		if ( planters.size() != 0)
			return new ResponseEntity <List<Planter>>(planters,HttpStatus.OK);
		return new ResponseEntity <List<Planter>>(planters,HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/planters/removeFromStock/{quantity}")
	public ResponseEntity<Planter> removePlantersFromStock(@RequestBody Planter planter, @PathVariable int quantity) {
		planter =  planterService.removePlantersFromStock(planter, quantity);
		return new ResponseEntity<Planter>(planter,HttpStatus.OK);
	}
	
	
//	SORTBY
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@GetMapping("/planters/costLowToHigh")
	public ResponseEntity<List<Planter>> costLowToHigh(){
		List<Planter> planters = planterService.costLowToHigh();
		return new ResponseEntity<List<Planter>>(planters,HttpStatus.OK);
	}
		
	@GetMapping("/planters/costHighToLow")
	public ResponseEntity<List<Planter>> costHighToLow(){
		List<Planter> planters = planterService.costHighToLow();
		return new ResponseEntity<List<Planter>>(planters,HttpStatus.OK);
	}
	
	
//	FILTER
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	

	@GetMapping("/plantersByColor/{color}")
	public ResponseEntity<List<Planter>> getPlanterByColor(@PathVariable String color){
		List<Planter> planters = planterService.viewPlantersByColor(color);
		if ( planters.size() != 0)
			return new ResponseEntity <List<Planter>>(planters,HttpStatus.OK);
		return new ResponseEntity <List<Planter>>(planters,HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/plantersByShape/{shape}")
	public ResponseEntity<List<Planter>> getPlanterByShape(@PathVariable String shape){
		List<Planter> planters = planterService.viewPlantersByShape(shape);
		if ( planters.size() != 0)
			return new ResponseEntity <List<Planter>>(planters,HttpStatus.OK);
		return new ResponseEntity <List<Planter>>(planters,HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/plantersByHeight/{height}")
	public ResponseEntity<List<Planter>> getPlanterByShape(@PathVariable float height){
		List<Planter> planters = planterService.viewPlantersByHeight(height);
		if ( planters.size() != 0)
			return new ResponseEntity <List<Planter>>(planters,HttpStatus.OK);
		return new ResponseEntity <List<Planter>>(planters,HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/plantersByCapacity/{capacity}")
	public ResponseEntity<List<Planter>> getPlanterByCapacity(@PathVariable int capacity){
		List<Planter> planters = planterService.viewPlantersByCapacity(capacity);
		if ( planters.size() != 0)
			return new ResponseEntity <List<Planter>>(planters,HttpStatus.OK);
		return new ResponseEntity <List<Planter>>(planters,HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/plantersByDrainageHoles/{drainageHoles}")
	public ResponseEntity<List<Planter>> getPlanterBydrainageHoles(@PathVariable int drainageHoles){
		List<Planter> planters = planterService.viewPlantersByDrainageHoles(drainageHoles);
		if ( planters.size() != 0)
			return new ResponseEntity <List<Planter>>(planters,HttpStatus.OK);
		return new ResponseEntity <List<Planter>>(planters,HttpStatus.NOT_FOUND);
		
	}
	
}
