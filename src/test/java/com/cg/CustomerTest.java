package com.cg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.sprint1_onlineplantnursery.entity.Address;
import com.cg.sprint1_onlineplantnursery.entity.Customer;
import com.cg.sprint1_onlineplantnursery.exception.CustomerNotFoundException;
import com.cg.sprint1_onlineplantnursery.repository.ICustomerRepository;
import com.cg.sprint1_onlineplantnursery.service.CustomerServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class CustomerTest {

	@Mock
	ICustomerRepository customerRepositoryMock;

	@InjectMocks
	CustomerServiceImpl customerServiceMock;

	static Customer c1;
	static Customer c2;
	static Customer c3;

	static Address a1;
	static Address a2;
	static Address a3;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		c1 = new Customer(1, "Pavan", "pavankumar@gmail.com", "Pavan@123");
		a1 = new Address("2-31", "Ram Nagar", "Ongole", "Andhra Pradesh", 523279);
		c1.setAddress(a1);

		c2 = new Customer(2, "Rahul", "rahulsai@gmail.com", "Sai@123");
		a2 = new Address("3-21", "Sri Nagar", "Ongole", "Andhra Pradesh", 523279);
		c2.setAddress(a2);

		c3 = new Customer(3, "Kumar", "kantu@gmail.com", "kantu@123");
		a3 = new Address("2-31", "Ram Nagar", "Hyderabad", "Telangana", 324389);
		c3.setAddress(a3);

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void addCustomerTest() {

		when(customerRepositoryMock.save(Mockito.anyObject())).thenReturn(c1);

		assertEquals("Pavan", customerServiceMock.addCustomer(c1).getName());

		// verify(customerServiceMock).addCustomer(c1);

	}

	@Test
	public void updateCustomerTest() {
		c1 = new Customer(1, "Pavan", "pavankumarkantu@gmail.com", "Pavan@123");
		a1 = new Address("2-31", "Ram Nagar", "Ongole", "Andhra Pradesh", 523279);
		c1.setAddress(a1);


		when(customerRepositoryMock.findById(1)).thenReturn(Optional.of(c1));
		when(customerRepositoryMock.save(Mockito.anyObject())).thenReturn(c1);

		assertEquals("pavankumarkantu@gmail.com", customerServiceMock.updateCustomer(1, c1).getEmail());

	}

	@Test
	public void deleteCustomerTest() {

		when(customerRepositoryMock.findById(2)).thenReturn(Optional.of(c2));
		assertEquals("Ongole", customerServiceMock.deleteCustomer(2).getAddress().getCity());

		Exception exception = assertThrows(CustomerNotFoundException.class,
				() -> customerServiceMock.deleteCustomer(12));
		assertTrue(exception.getMessage().contains("There are no customer having id:12"));

	} 

	@Test
	public void validateCustomerTest() {

		when(customerRepositoryMock.findByEmail("kantu@gmail.com")).thenReturn(Optional.of(c3));
		assertEquals("kantu@123", customerServiceMock.validateCustomer(c3).getPassword());

		Exception exception = assertThrows(CustomerNotFoundException.class,() -> customerServiceMock.validateCustomer(c1));
		assertTrue(exception.getMessage().contains("Bad Credentials"));

	}

	@Test
	public void getCustomerTest() {

		when(customerRepositoryMock.findById(2)).thenReturn(Optional.of(c2));
		assertEquals("Rahul", customerServiceMock.getCustomer(2).getName());

		Exception exception = assertThrows(CustomerNotFoundException.class, () -> customerServiceMock.getCustomer(11));
		assertTrue(exception.getMessage().contains("There are no customer having id:11"));

	}

	@Test
	public void getCustomersTest() {
		List<Customer> customers = new ArrayList<>();
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);

		when(customerRepositoryMock.findAll()).thenReturn(customers);
		assertEquals(3, customerServiceMock.getCustomers().size());

	}

}
