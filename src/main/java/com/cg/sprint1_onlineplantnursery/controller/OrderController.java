package com.cg.sprint1_onlineplantnursery.controller;

import java.util.List;
import javax.validation.Valid;
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

import com.cg.sprint1_onlineplantnursery.entity.Order;
import com.cg.sprint1_onlineplantnursery.service.IOrderService;

@RestController
@RequestMapping("/orders")
public class OrderController{
	
	@Autowired
	private IOrderService orderService;
	
	@PostMapping
	public ResponseEntity<Order> addOrder(@Valid @RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.addOrder(order), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Order> update(@Valid @RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.patchOrder(order), HttpStatus.OK);
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<String> delete(@PathVariable int id)  {
		orderService.deleteOrder(id);
		return new ResponseEntity<String>("The order with id " + id + " got deleted.", HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Order> viewOrder(@PathVariable int id) {
		return new ResponseEntity<Order>(orderService.viewOrder(id), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> getAllOrders(){
		return new ResponseEntity<List<Order>>(orderService.viewAllOrders(), HttpStatus.OK);
	}
}