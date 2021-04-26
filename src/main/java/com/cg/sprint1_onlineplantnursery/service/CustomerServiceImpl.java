package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.cg.sprint1_onlineplantnursery.entity.Customer;
import com.cg.sprint1_onlineplantnursery.entity.Order;
import com.cg.sprint1_onlineplantnursery.entity.Role;
import com.cg.sprint1_onlineplantnursery.entity.Status;
import com.cg.sprint1_onlineplantnursery.entity.User;
import com.cg.sprint1_onlineplantnursery.exception.ResourceNotFoundException;
import com.cg.sprint1_onlineplantnursery.exception.UserAlreadyExists;
import com.cg.sprint1_onlineplantnursery.exception.UserNotFoundException;
import com.cg.sprint1_onlineplantnursery.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;

	@Override
	public Customer register(Customer customer) {

		if (customerRepository.findByEmail(customer.getEmail()).isPresent())
			throw new UserAlreadyExists("Email is already registered.Try to login");

		customer.setRole(Role.CUSTOMER);
		customer.setStatus(Status.UNBLOCK);
		Customer save = customerRepository.save(customer);

		return save;
	}

	// method to find the details of the customer using customer Id

	@Override
	public Customer getCustomer(int customerId) {
		Optional<Customer> findById = customerRepository.findById(customerId);

		return findById.orElseThrow(() -> new UserNotFoundException("There are no customer having id:" + customerId));
	}

	// method to get all the customers

	@Override
	public List<Customer> getCustomers() {

		if (customerRepository.findAll().isEmpty())
			throw new UserNotFoundException("There are no records");

		return customerRepository.findAll();

	}

	// method to delete the customer using customer Id

	@Override
	public Customer deleteCustomer(int customerId) {

		Optional<Customer> findById = customerRepository.findById(customerId);
		findById.orElseThrow(() -> new UserNotFoundException("There are no customer having id:" + customerId));

		customerRepository.deleteById(customerId);

		return findById.get();
	}

	// method to find the all the order details of the customer using customer Id
	@Override
	public List<Order> getOrders(Integer id) {

		Optional<Customer> findById = customerRepository.findById(id);
		Customer customer = findById.orElseThrow(() -> new UserNotFoundException("Customer not found:"));

		if (customer.getOrders().isEmpty())
			throw new ResourceNotFoundException("Order not found");
		return customer.getOrders();
	}

	// method to get the order details of a customerId and orderId

	@Override
	public Order getOrderDetails(Integer customerId, Integer orderId) {

		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new UserNotFoundException("Customer not found"));

		List<Order> collect = customer.getOrders().stream().filter(order -> order.getBookingId() == orderId)
				.collect(Collectors.toList());

		if (collect.isEmpty()) {
			throw new ResourceNotFoundException("Orders not found");
		}

		return collect.get(0);
	}

	@Override
	public Customer getUser(String email) {
		Optional<Customer> findByEmail = customerRepository.findByEmail(email);

		System.out.println("I am in controller");
		System.out.println(findByEmail.isEmpty());
		System.out.println(email);
		return findByEmail
				.orElseThrow(() -> new UserNotFoundException("There are no customer having id:" + findByEmail));

	}

	@Override
	public Customer toggleStatus(Integer customerId) {
		Customer customer = null;
		Optional<Customer> findById = customerRepository.findById(customerId);

		if (findById.isPresent()) {
			customer = findById.get();

			if (customer.getStatus().equals(Status.UNBLOCK)) {
				customer.setStatus(Status.BLOCK);
			} else if (customer.getStatus().equals(Status.BLOCK)) {
				customer.setStatus(Status.UNBLOCK);
			}

		}

		Customer save = customerRepository.save(customer);
		return save;
	}


}