package com.cg;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.sprint1_onlineplantnursery.entity.Order;
import com.cg.sprint1_onlineplantnursery.repository.IOrderRepository;
import com.cg.sprint1_onlineplantnursery.service.IOrderService;
import com.cg.sprint1_onlineplantnursery.service.IOrderServiceImpl;

@SpringBootTest
class Sprint1OnlinePlantNurseryApplicationTests {
	
	@Autowired
    private IOrderService orderService;

	@Test
	public void addOrderTest() {

		Order ord = new Order(LocalDate.now(), "UPI", 350, 2000.0);
		Order ord1 = new Order(LocalDate.now(), "Cash", 25, 250.0);
		
		orderService.addOrder(ord);
		
		System.out.println("Added");
		
		assertEquals(ord, orderService.addOrder(ord));

	}

}
