package com.cg;

import java.time.LocalDate;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.sprint1_onlineplantnursery.entity.Address;
import com.cg.sprint1_onlineplantnursery.entity.Customer;
import com.cg.sprint1_onlineplantnursery.entity.Order;

import com.cg.sprint1_onlineplantnursery.service.ICustomerService;

@SpringBootTest
class Sprint1OnlinePlantNurseryApplicationTests {

	@Autowired
	private ICustomerService customerService;

	
	@Test
	public void testaddcustomer() {

		Customer c = new Customer("Pavan", "PavanKumar",  "kumar");

		Address a = new Address("2-31", "Sri ram", "Ongole", "Andhra", 523279);

		//c.addAddress(a);

		Customer addCustomer = customerService.addCustomer(c);

	}

	@Test
	public void placeOrder() {

		Order order = new Order( LocalDate.now(), "UPI", 35, 200.0);
           
		Order order2 =new Order(LocalDate.now().plusMonths(1),"CASH",37,300.0);

		Customer c = new Customer("Pavan", "PavanKumar",  "kumar");

		Address a = new Address("2-31", "Sri ram", "Ongole", "Andhra", 523279);

		c.setAddress(a);
		c.addOrder(order);
		c.addOrder(order2);

		Customer addCustomer = customerService.addCustomer(c);

	}

}
