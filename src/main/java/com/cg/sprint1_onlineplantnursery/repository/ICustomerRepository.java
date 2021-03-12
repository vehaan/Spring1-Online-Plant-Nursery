package com.cg.sprint1_onlineplantnursery.repository;

import java.util.List;

import com.cg.sprint1_onlineplantnursery.entity.Customer;

public interface ICustomerRepository {
	Customer addCustomer(Customer customer);

	Customer updateCustomer(Customer tenant);

	Customer deleteCustomer(Customer tenant);

	Customer viewCustomer(int customerId);

	List<Customer> viewAllCustomers();

	boolean validateCustomer(String userName, String password);
}
