package com.cg.sprint1_onlineplantnursery.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint1_onlineplantnursery.entity.Order;
import com.cg.sprint1_onlineplantnursery.exception.OrderIdNotFoundException;
import com.cg.sprint1_onlineplantnursery.service.IOrderService;

@RestController
@RequestMapping("/orders")
public class IOrderController extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private IOrderService orderService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http.csrf().disable();
	}
	
	@PostMapping
	public ResponseEntity<Order> addOrder(@Valid @RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.addOrder(order), HttpStatus.CREATED);
	}
	
	/*
	 * @PutMapping public ResponseEntity<Order> update(@Valid @RequestBody Order
	 * order) { return new ResponseEntity<Order>(orderService.updateOrder(order),
	 * HttpStatus.OK); }
	 */
	
	@PutMapping
	public ResponseEntity<Order> patch(@Valid @RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.patchOrder(order), HttpStatus.OK);
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<Order> delete(@PathVariable int id)  {
		return new ResponseEntity<Order>(orderService.deleteOrder(id), HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Order> viewOrder(@PathVariable int id) {
		return new ResponseEntity<Order>(orderService.viewOrder(id), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> getAllOrders(){
		return new ResponseEntity<List<Order>>(orderService.viewAllOrders(), HttpStatus.OK);
	}
	
	/*
	 * @PatchMapping("id/{id}") public ResponseEntity<Order>
	 * updateOrder(@PathVariable int id, @RequestBody Map<Object,Object> fields){
	 * Order order = orderService.viewOrder(id); fields.forEach((k,v) -> { Field
	 * field = ReflectionUtils.findRequiredField(Order.class, (String) k);
	 * field.setAccessible(true); ReflectionUtils.setField(field, order, v); });
	 * return new
	 * ResponseEntity<Order>(orderService.updateOrder(order),HttpStatus.ACCEPTED); }
	 */
}
