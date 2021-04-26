package com.cg.sprint1_onlineplantnursery.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.sprint1_onlineplantnursery.entity.Order;
import com.cg.sprint1_onlineplantnursery.entity.TransactionMode;
import com.cg.sprint1_onlineplantnursery.service.IOrderService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class OrderController{
	
	@Autowired
	private IOrderService orderService;
	
	@PostMapping({"/admin/order", "/customers/order"})
	public ResponseEntity<Order> addOrder(@Valid @RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.addOrder(order), HttpStatus.CREATED);
	}
	
	@PutMapping("/admin/order")
	public ResponseEntity<Order> update(@Valid @RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.patchOrder(order), HttpStatus.OK);
	}
	
	@DeleteMapping("/admin/order/id/{id}")
	public ResponseEntity<String> delete(@PathVariable int id)  {
		orderService.deleteOrder(id);
		return new ResponseEntity<String>("The order with id " + id + " got deleted.", HttpStatus.OK);
	}
	
	@GetMapping("/admin/order/id/{id}")
	public ResponseEntity<Order> viewOrder(@PathVariable int id) {
		return new ResponseEntity<Order>(orderService.viewOrder(id), HttpStatus.OK);
	}
	
	@GetMapping("/admin/orders")
	public ResponseEntity<List<Order>> getAllOrders(){
		return new ResponseEntity<List<Order>>(orderService.viewAllOrders(), HttpStatus.OK);
	}
	
	@GetMapping("/admin/orders/costLowToHigh")
	public ResponseEntity<List<Order>> sortOrderLowToHigh(){
		return new ResponseEntity<List<Order>>(orderService.sortOrderLowToHigh(), HttpStatus.OK);
	}
	
	@GetMapping("/admin/orders/costHighToLow")
	public ResponseEntity<List<Order>> sortOrderHighToLow(){
		return new ResponseEntity<List<Order>>(orderService.sortOrderHighToLow(), HttpStatus.OK);
	}
	
	@GetMapping("/admin/orders/filterByTransactionMode/{mode}")
	public ResponseEntity<List<Order>> viewByTransactionMode(@PathVariable TransactionMode mode){
		return new ResponseEntity<List<Order>>(orderService.filterByTransactionMode(mode), HttpStatus.OK);
	}
	
	@GetMapping("/customer/order/id/{custId}/{orderId}")
	public ResponseEntity<Order> viewOrder(@PathVariable int custId, @PathVariable int orderId) {
		return new ResponseEntity<Order>(orderService.viewOrder(custId, orderId), HttpStatus.OK);
	}
	
	@GetMapping("/customer/orders/{custId}")
	public ResponseEntity<List<Order>> getAllOrders(@PathVariable int custId){
		return new ResponseEntity<List<Order>>(orderService.viewAllOrders(custId), HttpStatus.OK);
	}
	
	@GetMapping("/customer/orders/filterByTransactionMode/{mode}/{customerId}")
    public ResponseEntity<List<Order>> viewByTransactionMode(@PathVariable TransactionMode mode, @PathVariable int customerId){
        return new ResponseEntity<List<Order>>(orderService.filterByTransactionMode(mode, customerId), HttpStatus.OK);
    }
	
}