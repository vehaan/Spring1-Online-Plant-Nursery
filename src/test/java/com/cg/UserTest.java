package com.cg;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.sprint1_onlineplantnursery.entity.Address;
import com.cg.sprint1_onlineplantnursery.entity.Admin;
import com.cg.sprint1_onlineplantnursery.entity.Customer;
import com.cg.sprint1_onlineplantnursery.repository.IUserRepository;
import com.cg.sprint1_onlineplantnursery.service.UserServiceImpl;


@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class UserTest {
	
	
	
	@Mock
	IUserRepository userRepositoryMock;

	@InjectMocks
	UserServiceImpl userServiceMock;

	static Customer c1, c2;
	static Admin a1, a2;

	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		c1 = new Customer(1, "rahul@gmail.com", "rahul@123", "customer", "Rahul sai", "9666635326",
				new Address("3-21", "sarathnagar", "kondepi", "Andhra Pradesh", 523276));

		c2 = new Customer(2, "kantu@gmail.com", "kantu@123", "customer", "Kantu Kumar", "9846478462",
				new Address("3-22", "Jogipet", "Sangareddy", "Telangana", 532456));
		
		a1 = new Admin("Sravan@gmail", "saran@123", "admin", "Sravan Kumar", "987654321");
		
		a2 = new Admin("ramesh@gmail", "ramesh@123", "admin", "Suresh", "8927654262");
				
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
	public void customerRegister() {
		
		when(userRepositoryMock.save(Mockito.anyObject())).thenReturn(c1);
		assertEquals("Rahul sai", ((Customer) userServiceMock.register(c1)).getName());
		
	}
	
	@Test
	public void adminRegister() {
		
		when(userRepositoryMock.save(Mockito.anyObject())).thenReturn(a2);
		assertEquals("Suresh", ((Admin) userServiceMock.register(a2)).getName());
		
	}
	
	
	
	
	
	
	
	
}
