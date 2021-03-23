package com.cg;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.sprint1_onlineplantnursery.entity.Address;
import com.cg.sprint1_onlineplantnursery.entity.Customer;
import com.cg.sprint1_onlineplantnursery.entity.Order;
import com.cg.sprint1_onlineplantnursery.entity.Plant;
import com.cg.sprint1_onlineplantnursery.entity.Planter;
import com.cg.sprint1_onlineplantnursery.entity.Seed;
import com.cg.sprint1_onlineplantnursery.repository.IOrderRepository;
import com.cg.sprint1_onlineplantnursery.service.IOrderServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class OrderTest {

	@Mock
	IOrderRepository orderRepoMock;
	
	@InjectMocks
	IOrderServiceImpl orderServiceMock;
	
	static Order order1;
	static Order order2;
	static List<Order> orders = new ArrayList<>();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Map<Integer, Integer> pmap = new HashMap<>();
		Plant p = new Plant(3,8,"fast","Lemon","summer","for lemons","easy","hot","shrub","fruit-plant",50/*stock*/,10.0);
		pmap.put(p.getId(), 10);
		
		Seed s = new Seed(14,"Rose","5 days","Easy","Medium","20 degree celcius","Flower","For Rose",50/*stock*/,2,4);
		Map<Integer, Integer> smap = new HashMap<>();
		smap.put(s.getSeedId(), 100);
		
		Planter pr = new Planter(1,34.50f,500,2,"Red","Circle",300/*stock*/,2000);
		Map<Integer, Integer> prmap = new HashMap<>();
		prmap.put(pr.getPlanterId(), 5);
		
		Customer cust = new Customer("Kamalesh", "ks@gmail.com", "kamal1234", new Address("24-3-437", "JVR", "Nellore", "AP", 524003));
		
		order1 = new Order(1, LocalDate.now(), "UPI", 100, 200.0, pmap, smap, prmap, cust);
		order2 = new Order(5, LocalDate.now(), "Cash", 150, 200.0, pmap, smap, prmap, cust);
		
		orders.add(order1);
		orders.add(order2);
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
	
	//@Order(1)
	//@Disabled
	@Test
	public void addNewOrderTest() {
		when(orderRepoMock.save(order1)).thenReturn(order1);
		assertEquals("UPI", orderServiceMock.addOrder(order1).getTransactionMode());	
	}
	
	//Some Problem with UPDATE ORDER
	//@Order(2)
	//@Disabled
	@Test
	public void updateOrderTest() {
		when(orderRepoMock.findById(5)).thenReturn(Optional.of(order2));
		
		Map<Integer, Integer> pmap = new HashMap<>();
		Plant p = new Plant(3,8,"fast","Lemon","summer","for lemons","easy","hot","shrub","fruit-plant",50/*stock*/,10.0);
		pmap.put(p.getId(), 10);
		System.out.println("Plant map is created");
		
		Seed s = new Seed(14,"Rose","5 days","Easy","Medium","20 degree celcius","Flower","For Rose",50/*stock*/,2,4);
		Map<Integer, Integer> smap = new HashMap<>();
		smap.put(s.getSeedId(), 100);
		System.out.println("Seed map is created");
		
		Planter pr = new Planter(1,34.50f,500,2,"Red","Circle",300/*stock*/,2000);
		Map<Integer, Integer> prmap = new HashMap<>();
		prmap.put(pr.getPlanterId(), 5);
		System.out.println("Planter map is created");
		
		Customer cust = new Customer("Kamalesh", "ks@gmail.com", "kamal1234", new Address("24-3-437", "JVR", "Nellore", "AP", 524003));
		
		Order updateOrder2 = new Order(5, LocalDate.now(), "Cash", 160, 200.0, pmap, smap, prmap, cust);
		//updating quantity from 150 to 160
		when(orderRepoMock.save(order2)).thenReturn(order2);
		assertEquals(160, orderServiceMock.updateOrder(updateOrder2).getQuantity());
		
	}
	
	//@Order(3)
	//@Disabled
	@Test
	public void deleteOrderTest() {
		when(orderRepoMock.findById(5)).thenReturn(Optional.of(order2));
		assertEquals("Cash", orderServiceMock.deleteOrder(5).getTransactionMode());
	}
	
	//@Order(4)
	//@Disabled
	@Test
	public void viewOrder() {
		when(orderRepoMock.findById(1)).thenReturn(Optional.of(order1));		
		assertEquals(100, orderServiceMock.viewOrder(1).getQuantity());
	}
	
	//@Order(5)
	//@Disabled
	@Test
	public void viewAllOrdersTest() {
		when(orderRepoMock.findAll()).thenReturn(orders);		
		assertEquals(2, orderServiceMock.viewAllOrders().size());
	}
	
	
}
