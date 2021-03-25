package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.cg.sprint1_onlineplantnursery.entity.Customer;
import com.cg.sprint1_onlineplantnursery.entity.Order;
import com.cg.sprint1_onlineplantnursery.exception.ResourceNotFoundException;
import com.cg.sprint1_onlineplantnursery.exception.UserNotFoundException;

@Service
public interface ICustomerService {
		
	
	Customer deleteCustomer(int customerId) throws UserNotFoundException;
	
	Customer getCustomer(int customerId) throws UserNotFoundException;
	
	List<Customer> getCustomers() throws UserNotFoundException;
		
	List<Order> getOrders(Integer id) throws UserNotFoundException,ResourceNotFoundException;
	
	Order getOrderDetails(Integer customerId, Integer orderId)throws UserNotFoundException,ResourceNotFoundException;
	
	
	
}