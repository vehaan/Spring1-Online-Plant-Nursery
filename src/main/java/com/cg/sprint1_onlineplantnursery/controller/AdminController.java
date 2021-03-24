package com.cg.sprint1_onlineplantnursery.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint1_onlineplantnursery.entity.Admin;
import com.cg.sprint1_onlineplantnursery.entity.Customer;
import com.cg.sprint1_onlineplantnursery.entity.User;
import com.cg.sprint1_onlineplantnursery.service.ICustomerService;
import com.cg.sprint1_onlineplantnursery.service.IProductService;
import com.cg.sprint1_onlineplantnursery.service.IUserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IUserService userService;

	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	IProductService productService;	

	@PostMapping("/register")
	public ResponseEntity<User> addAdmin(@RequestBody Admin user) {

		return new ResponseEntity<>(userService.register(user), HttpStatus.OK);

	}

	@PostMapping("/account")
	public ResponseEntity<String> login(@RequestBody User user) {

		return new ResponseEntity<String>("Welcome " + ((Admin) userService.login(user)).getName(),
				HttpStatus.ACCEPTED);

	}

	@PatchMapping("/resetPassword/{id}")
	public ResponseEntity<String> resetPassword(@Valid @PathVariable Integer id,
			@RequestBody Map<Object, Object> fields) {

		return new ResponseEntity<>("Your password is successfully updated "
				+ ((Admin) userService.resetPasswordById(id, fields)).getName(), HttpStatus.CREATED);

	}

	@PatchMapping("/resetEmail/{id}")
	public ResponseEntity<String> resetEmail(@Valid @PathVariable Integer id, @RequestBody Map<Object, Object> fields) {

		return new ResponseEntity<>(
				"Your email is successfully updated " + (((Admin) userService.resetEmailById(id, fields)).getName()),
				HttpStatus.CREATED);

	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> viewById(@PathVariable Integer id) {

		return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);
	}

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> allCustomers() {

		return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);

	}

}
