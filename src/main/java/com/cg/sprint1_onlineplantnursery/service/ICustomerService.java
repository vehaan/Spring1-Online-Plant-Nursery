package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.sprint1_onlineplantnursery.entity.Customer;
import com.cg.sprint1_onlineplantnursery.entity.Order;
import com.cg.sprint1_onlineplantnursery.entity.User;
import com.cg.sprint1_onlineplantnursery.exception.UserNotFoundException;

@Service
public interface ICustomerService {
	
	
	Customer addCustomer(Customer customer) throws UserNotFoundException;
	
	Customer updateCustomer(int customerId,Customer customer) throws UserNotFoundException;	
	
	Customer deleteCustomer(int customerId) throws UserNotFoundException;
	
	Customer getCustomer(int customerId) throws UserNotFoundException;
	
	List<Customer> getCustomers() throws UserNotFoundException;
		
	List<Order> getOrders(Integer id) ;
	
	Order getOrderDetails(Integer customerId, Integer orderId);
	
}

