package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.cg.sprint1_onlineplantnursery.entity.Address;
import com.cg.sprint1_onlineplantnursery.entity.Customer;
import com.cg.sprint1_onlineplantnursery.entity.Order;
import com.cg.sprint1_onlineplantnursery.exception.CustomerNotFoundException;
import com.cg.sprint1_onlineplantnursery.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository repo;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerNotFoundException {
		Customer save = null;

		if (customer != null) {

			List<Order> orders = customer.getOrders();

			if (orders != null) {
				for (Order order : orders) {
					order.setCustomer(customer);

				}
			}

			save = repo.save(customer);
		} else {
			throw new CustomerNotFoundException("Customer cannot be null");
		}

		return save;
	}

	@Override
	public Customer updateCustomer(int customerId, Customer customer) throws CustomerNotFoundException {

		Optional<Customer> findById = repo.findById(customerId);

		return findById
				.orElseThrow(() -> new CustomerNotFoundException("There are no customer having id: " + customerId));
	}

	@Override
	public Customer deleteCustomer(int customerId) throws CustomerNotFoundException {

		Optional<Customer> findById = repo.findById(customerId);

		return findById
				.orElseThrow(() -> new CustomerNotFoundException("There are no customer having id:" + customerId));
	}

	@Override
	public Customer getCustomer(int customerId) throws CustomerNotFoundException {
		Optional<Customer> findById = repo.findById(customerId);

		return findById
				.orElseThrow(() -> new CustomerNotFoundException("There are no customer having id:" + customerId));
	}

	@Override
	public List<Customer> getCustomers() {

		return repo.findAll();

	}

	@Override
	public Customer validateCustomer(Customer tenant) throws CustomerNotFoundException {

		String userName = tenant.getUsername();
		String password = tenant.getPassword();

		Optional<Customer> customer = repo.findByUsername(userName);

		if (!customer.get().getPassword().equals(password)) {

			throw new CustomerNotFoundException("Bad Credentials");
		}

		return customer.get();
	}

}
