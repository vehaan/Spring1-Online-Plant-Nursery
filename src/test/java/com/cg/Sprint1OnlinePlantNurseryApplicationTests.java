package com.cg;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.cg.sprint1_onlineplantnursery.entity.Address;
import com.cg.sprint1_onlineplantnursery.entity.Admin;
import com.cg.sprint1_onlineplantnursery.entity.Customer;
import com.cg.sprint1_onlineplantnursery.entity.Order;
import com.cg.sprint1_onlineplantnursery.entity.User;
import com.cg.sprint1_onlineplantnursery.service.ICustomerService;
import com.cg.sprint1_onlineplantnursery.service.IUserService;

@SpringBootTest
class Sprint1OnlinePlantNurseryApplicationTests {

	@Autowired
	private ICustomerService customerService;

	@Autowired
	private IUserService userService;

	@Test
	@Transactional
	@Rollback(false)
	public void testaddcustomer() {

		/*
		 * //Customer c = new Customer("Pavan", "PavanKumar", "kumar");
		 * 
		 * Address a = new Address("2-31", "Sri ram", "Ongole", "Andhra", 523279);
		 * 
		 * //c.addAddress(a);
		 * 
		 * Customer addCustomer = customerService.addCustomer(c);
		 */

		/*
		 * User c1 = new Customer("pavan@gmail.com", "Pavan@123", "customer",
		 * "Pavan Kumar", "9182183522", new Address("2-31", "Sai nagar", "Ongole",
		 * "Andhra Pradesh", 523279));
		 * 
		 * 
		 * userService.register(c1);
		 */
		/*
		 * User a = new Admin("admin2@gmail.com", "oracle123", "admin", "Shankar",
		 * "9812135459");
		 * 
		 * userService.register(a);
		 */
		/*
		 * User c3 = new Customer(3, "kantuPavan2@gmail.com", "kantu@123", "customer",
		 * "Kantu Kumar", "9846478462", new Address("3-22", "Jogipet", "Sangareddy",
		 * "Telangana", 532456));
		 * 
		 * Order o1 = new Order(LocalDate.now(), "Cash", 20, 200.0);
		 * 
		 * Order o2 = new Order(LocalDate.now().plusMonths(1),"Card",10,300.0);
		 * 
		 * 
		 * 
		 * 
		 * ((Customer)c3).addOrder(o1); ((Customer)c3).addOrder(o2);
		 * 
		 * userService.register(c3);
		 */
		Customer c2 = new Customer( "rahul@gmail.com", "rahul@123", "customer", "Rahul sai", "9666635326",
				new Address("3-21", "sarathnagar", "kondepi", "Andhra Pradesh", 523276));
		
		userService.register(c2);
		
		// Order o2 = new Order(1, LocalDate.now().plusDays(7), "Card", 21, 100.0, c2);
		 
		 
		
	}

	@Test
	public void placeOrder() {
		/*
		 * Order order = new Order( LocalDate.now(), "UPI", 35, 200.0);
		 * 
		 * Order order2 =new Order(LocalDate.now().plusMonths(1),"CASH",37,300.0);
		 * 
		 * //Customer c = new Customer("Pavan", "PavanKumar", "kumar");
		 * 
		 * Address a = new Address("2-31", "Sri ram", "Ongole", "Andhra", 523279);
		 * 
		 * c.setAddress(a); c.addOrder(order); c.addOrder(order2);
		 * 
		 * Customer addCustomer = customerService.addCustomer(c);
		 */
	}

}
