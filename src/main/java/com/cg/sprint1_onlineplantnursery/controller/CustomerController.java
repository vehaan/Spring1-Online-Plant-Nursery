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
import com.cg.sprint1_onlineplantnursery.entity.Order;
import com.cg.sprint1_onlineplantnursery.entity.User;
import com.cg.sprint1_onlineplantnursery.service.ICustomerService;
import com.cg.sprint1_onlineplantnursery.service.IUserService;

@RestController
@RequestMapping("/customers")
public class CustomerController extends WebSecurityConfigurerAdapter {

	@Autowired
	private ICustomerService customerService;

	@Autowired
	private IUserService userService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http.csrf().disable();
	}

	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@PostMapping("/register")
	public ResponseEntity<User> register(@Valid @RequestBody Customer customer) {

		logger.trace("Adding  the customer");

		return new ResponseEntity<>(userService.register(customer), HttpStatus.CREATED);
	}

	@PostMapping("/account")
	public ResponseEntity<String> login(@RequestBody User user) {

		return new ResponseEntity<String>("Welcome " + ((Customer) userService.login(user)).getName(),
				HttpStatus.ACCEPTED);

	}

	@PatchMapping("/resetPassword/{id}")
	public ResponseEntity<String> resetPassword(@Valid @PathVariable Integer id,
			@RequestBody Map<Object, Object> fields) {

		return new ResponseEntity<>("Your password is successfully updated "
				+ ((Customer) userService.resetPasswordById(id, fields)).getName(), HttpStatus.CREATED);
	}

	@PatchMapping("/resetEmail/{id}")
	public ResponseEntity<String> resetEmail(@Valid @PathVariable Integer id, @RequestBody Map<Object, Object> fields) {

		return new ResponseEntity<>("Your password is successfully updated "
				+ (((Customer) userService.resetEmailById(id, fields)).getName()), HttpStatus.CREATED);
	}

	@PutMapping("/id/{id}")
	public ResponseEntity<Customer> update(@Valid @PathVariable Integer id, @RequestBody Customer customer) {

		logger.trace("Updating the customer having id : " + id);

		return new ResponseEntity<Customer>(customerService.updateCustomer(id, customer), HttpStatus.CREATED);
	}

	@DeleteMapping("/id/{id}")
	public ResponseEntity<Customer> deleteById(@PathVariable Integer id) {

		logger.trace("Deleting the customer having id : " + id);

		return new ResponseEntity<Customer>(customerService.deleteCustomer(id), HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Integer id) {

		return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Customer>> getCustomers() {

		return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
	}

	@GetMapping("/orders/id/{id}")
	public ResponseEntity<List<Order>> getByCustomerId(@PathVariable Integer id) {

		return new ResponseEntity<>(customerService.getOrders(id), HttpStatus.OK);
	}

	@GetMapping("/orders/{customerId}/{orderId}")
	public ResponseEntity<Order> getBycustomerIdAndOrderId(@PathVariable Integer customerId,
			@PathVariable Integer orderId) {

		return new ResponseEntity<>(customerService.getOrderDetails(customerId, orderId), HttpStatus.OK);
	}

}
