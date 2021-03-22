package com.cg.sprint1_onlineplantnursery.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;
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

		if (repo.findByEmail(customer.getEmail()).isPresent())
			throw new CustomerNotFoundException("Email is already registered.Try to login");

		else {

			List<Order> orders = customer.getOrders();

			if (orders != null) {
				for (Order order : orders)
					order.setCustomer(customer);
			}
			save = repo.save(customer);
		}
		return save;
	}

	@Override
	public Customer updateCustomer(int customerId, Customer customer) throws CustomerNotFoundException {

		Optional<Customer> findById = repo.findById(customerId);
		findById.orElseThrow(() -> new CustomerNotFoundException("There are no customer having id: " + customerId));

		return repo.save(customer);
	}

	@Override
	public Customer resetPasswordById(Integer id, Map<Object, Object> fields) {

		if (repo.findById(id).isEmpty())
			throw new CustomerNotFoundException("Not customer found by id : " + id);
		else {

			Customer customer = repo.findById(id).get();

			fields.forEach((k, v) -> {
				Field field = ReflectionUtils.findRequiredField(Customer.class, (String) k);

				field.setAccessible(true);

				try {
					if (field.getName().equals("email")) {
						if (!field.get(customer).toString().equals(v.toString()))
							throw new CustomerNotFoundException("Email mismatch for the id :" + id);

					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
                       
					
				}
				ReflectionUtils.setField(field, customer, v);
			});

			return repo.save(customer);
		}

	}
	
	
	@Override
	public Customer deleteCustomer(int customerId) throws CustomerNotFoundException {

		Optional<Customer> findById = repo.findById(customerId);
		findById.orElseThrow(() -> new CustomerNotFoundException("There are no customer having id:" + customerId));

		repo.deleteById(customerId);

		return findById.get();
	}

	@Override
	public Customer getCustomer(int customerId) throws CustomerNotFoundException {
		Optional<Customer> findById = repo.findById(customerId);

		return findById
				.orElseThrow(() -> new CustomerNotFoundException("There are no customer having id:" + customerId));
	}

	@Override
	public List<Customer> getCustomers() {

		if (repo.findAll().isEmpty())
			throw new CustomerNotFoundException("There are no records");

		return repo.findAll();

	}

	@Override
	public Customer validateCustomer(Customer tenant) throws CustomerNotFoundException {

		String userName = tenant.getEmail();
		String password = tenant.getPassword();

		Optional<Customer> customer = repo.findByEmail(userName);

		if (customer.isEmpty() || !customer.get().getPassword().equals(password)) {

			throw new CustomerNotFoundException("Bad Credentials");
		}

		return customer.get();
	}

}
