package com.cg.sprint1_onlineplantnursery.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.cg.sprint1_onlineplantnursery.entity.Customer;
import com.cg.sprint1_onlineplantnursery.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController extends WebSecurityConfigurerAdapter {

	@Autowired
	private ICustomerService customerService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http.csrf().disable();
	}

	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@PostMapping("/register")
	public ResponseEntity<Customer> register(@Valid @RequestBody Customer customer) {
		
		logger.trace("Adding  the customer");

		return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.CREATED);
	}

	@PostMapping("/account")

	public ResponseEntity<String> login(@RequestBody Customer customer) {

		logger.trace("Validing  the customer using Email and Password");

		return new ResponseEntity<String>("Welcome " + customerService.validateCustomer(customer).getName(),
				HttpStatus.ACCEPTED);

	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Customer> viewById(@PathVariable Integer id) {

		logger.trace("Getting  the customer having id : " + id);

		return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);
	}

	@PutMapping("/id/{id}")
	public ResponseEntity<Customer> update(@Valid @PathVariable Integer id, @RequestBody Customer customer) {

		logger.trace("Updating the customer having id : " + id);

		return new ResponseEntity<Customer>(customerService.updateCustomer(id, customer), HttpStatus.CREATED);
	}

	@PatchMapping("/id/{id}")
	public ResponseEntity<String> resetPassword(@Valid @PathVariable Integer id,@RequestBody Map<Object, Object> fields) {

		logger.trace("Resetting the password for the customer id : " + id);
		customerService.resetPasswordById(id, fields);

		return new ResponseEntity<>("Your password is successfully updated", HttpStatus.CREATED);
	}

	@DeleteMapping("/id/{id}")
	public ResponseEntity<Customer> deleteById(@PathVariable Integer id) {

		logger.trace("Deleting the customer having id : " + id);

		return new ResponseEntity<Customer>(customerService.deleteCustomer(id), HttpStatus.OK);
	}

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> allCustomers() {
		logger.trace("Getting the records of the customers");
		return new ResponseEntity<List<Customer>>(customerService.getCustomers(), HttpStatus.OK);

	}

}
