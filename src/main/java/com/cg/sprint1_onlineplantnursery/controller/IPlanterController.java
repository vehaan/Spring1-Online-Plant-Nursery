package com.cg.sprint1_onlineplantnursery.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cg.sprint1_onlineplantnursery.entity.Planter;
import com.cg.sprint1_onlineplantnursery.exception.ResourceNotFoundException;
import com.cg.sprint1_onlineplantnursery.service.IPlanterService;
import com.cg.sprint1_onlineplantnursery.service.IPlanterServiceImpl;


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
	public ResponseEntity<Planter> getPlanterById(@PathVariable int id) throws ResourceNotFoundException {
		Planter planter = planterService.viewPlanter(id);
		return new ResponseEntity<Planter>(planter,HttpStatus.OK); 
	}
	
	//CUSTOMER CAN PLACE CHOICE AND ADMIN CAN UPDATE
	@PutMapping("/planter")
	public ResponseEntity<Planter> update(@RequestBody Planter planter) throws ResourceNotFoundException {
		Planter newPlanter =  planterService.updatePlanter(planter);
		return new ResponseEntity<Planter>(newPlanter,HttpStatus.OK);
	}
	
	//WHEN CUSTOMER BUYS OR ADMIN WANTS TO DELETE IF IT'S DESTROYED
	@DeleteMapping("/planter")
	public ResponseEntity<Planter> delete(@RequestBody Planter planter) throws ResourceNotFoundException {
		planter =  planterService.deletePlanter(planter);
		return new ResponseEntity<Planter>(planter,HttpStatus.OK);
		
	}
	
	//WHEN CUSTOMER BUYS THE ENTIRE STOCK OR ADMIN NO MORE WANTS TO SELL THAT ITEM
	@DeleteMapping("/planters/deleteStock/{id}")
	public ResponseEntity<Planter> deleteEntireStock(@PathVariable int id) throws ResourceNotFoundException {
		Planter planter =  planterService.deleteEntireStock(id);
		return new ResponseEntity<Planter>(planter,HttpStatus.OK);
	}
	
	//Both CUSTOMER AND ADMIN
	@GetMapping("/plantersByShape/{shape}")
	public ResponseEntity<List<Planter>> getPlanterByShape(@PathVariable String shape){
		List<Planter> planters = planterService.viewPlantersByShape(shape);
		if ( planters.size() != 0)
			return new ResponseEntity <List<Planter>>(planters,HttpStatus.OK);
		return new ResponseEntity <List<Planter>>(planters,HttpStatus.NOT_FOUND);
		
	}
	
	//BOTH CUSTOMER AND ADMIN
	@GetMapping("/planters/{min}/{max}")
	public ResponseEntity<List<Planter>> getAllPlantersInRange(@PathVariable double min, @PathVariable double max ){
		List<Planter> planters = planterService.viewAllPlanters(min, max);
		if ( planters.size() != 0)
			return new ResponseEntity <List<Planter>>(planters,HttpStatus.OK);
		return new ResponseEntity <List<Planter>>(planters,HttpStatus.NOT_FOUND);
	}
	
}