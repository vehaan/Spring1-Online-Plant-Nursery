package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.sprint1_onlineplantnursery.entity.Customer;
import com.cg.sprint1_onlineplantnursery.entity.Order;
import com.cg.sprint1_onlineplantnursery.entity.Role;
import com.cg.sprint1_onlineplantnursery.exception.UserNotFoundException;
import com.cg.sprint1_onlineplantnursery.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;

	// method to register the customer

	@Override
	public Customer addCustomer(Customer customer) throws UserNotFoundException {
		Customer save = null;
		if (customerRepository.findByEmail(customer.getEmail()).isPresent())
			throw new UserNotFoundException("Email is already registered.Try to login");
		else if (customer.getRole() == Role.ADMIN)
			throw new UserNotFoundException("Customer role cannot be admin");
		save = customerRepository.save(customer);
		return save;
	}

	// method to update the customer using customer Id

	@Override
	public Customer updateCustomer(int customerId, Customer customer) throws UserNotFoundException {

		Optional<Customer> findById = customerRepository.findById(customerId);
		findById.orElseThrow(() -> new UserNotFoundException("There are no customer having id: " + customerId));

		return customerRepository.save(customer);
	}

	// method to find the details of the customer using customer Id

	@Override
	public Customer getCustomer(int customerId) throws UserNotFoundException {
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
	public Customer deleteCustomer(int customerId) throws UserNotFoundException {

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
		
		if(customer.getOrders().isEmpty())
			throw new UserNotFoundException("Order not found");
		return customer.getOrders();
	}

	// method to get the order details of a customerId and orderId

	@Override
	public Order getOrderDetails(Integer customerId, Integer orderId) {

		Customer customer = customerRepository.findById(customerId)
				                        .orElseThrow(() -> new UserNotFoundException("Customer not found"));

		List<Order> collect = customer.getOrders().stream().filter(order -> order.getBookingId() == orderId)
				                                                    .collect(Collectors.toList());

		// TODO change the exception to order not found

		if (collect.isEmpty()) {
			throw new UserNotFoundException("Order not found");
		}

		return collect.get(0);
	}

}