package com.cg.sprint1_onlineplantnursery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.cg.sprint1_onlineplantnursery.entity.Customer;
import com.cg.sprint1_onlineplantnursery.exception.CustomerNotFoundException;
import com.cg.sprint1_onlineplantnursery.service.ICustomerService;

@RestController
@RequestMapping("/rest")
public class CustomerController extends WebSecurityConfigurerAdapter {

	@Autowired
	private ICustomerService customerService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http.csrf().disable();
	}

	@PostMapping("/register")
	public ResponseEntity<Customer> register(@RequestBody Customer customer) {

		return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.CREATED);
	}

	@PostMapping("/login")

	public ResponseEntity<String> login(@RequestBody Customer customer) {

		return new ResponseEntity<String>("Welcome " + customerService.validateCustomer(customer).getName(),
				HttpStatus.ACCEPTED);

	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Customer> viewById(@PathVariable Integer id) {

		return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);
	}

	@PutMapping("/id/{id}")
	public ResponseEntity<Customer> update(@PathVariable Integer id, @RequestBody Customer customer) {

		return new ResponseEntity<Customer>(customerService.updateCustomer(id, customer), HttpStatus.CREATED);
	}

	@DeleteMapping("/id/{id}")
	public ResponseEntity<Customer> deleteById(@PathVariable Integer id) {

		return new ResponseEntity<Customer>(customerService.deleteCustomer(id), HttpStatus.OK);
	}

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> allCustomers() {

		return new ResponseEntity<List<Customer>>(customerService.getCustomers(), HttpStatus.OK);

	}

}
