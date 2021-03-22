package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cg.sprint1_onlineplantnursery.entity.Customer;
import com.cg.sprint1_onlineplantnursery.exception.CustomerNotFoundException;

@Service
public interface ICustomerService {
	Customer addCustomer(Customer customer) throws CustomerNotFoundException;

	Customer updateCustomer(int customerId,Customer customer) throws CustomerNotFoundException;
	
	public Customer resetPasswordById(Integer id, Map<Object, Object> fields) throws CustomerNotFoundException;

	Customer deleteCustomer(int customerId) throws CustomerNotFoundException;

	Customer getCustomer(int customerId) throws CustomerNotFoundException;

	List<Customer> getCustomers() throws CustomerNotFoundException;

	Customer validateCustomer(Customer tenant) throws CustomerNotFoundException;
}
