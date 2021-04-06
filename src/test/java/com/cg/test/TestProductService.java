//package com.cg.test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.Ignore;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.cg.sprint1_onlineplantnursery.entity.Planter;
//import com.cg.sprint1_onlineplantnursery.entity.Product;
//import com.cg.sprint1_onlineplantnursery.entity.Type;
//import com.cg.sprint1_onlineplantnursery.repository.IPlanterRepository;
//import com.cg.sprint1_onlineplantnursery.repository.IProductRepository;
//import com.cg.sprint1_onlineplantnursery.service.PlanterServiceImpl;
//import com.cg.sprint1_onlineplantnursery.service.ProductServiceImpl;
//
//@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
//@Ignore
//public class TestProductService {
//	
//
//	@Mock
//	IProductRepository dao;
//	
//	@InjectMocks
//	ProductServiceImpl service;
//	
//	List<Product> productList;
//	Product product1;
//	Product product2;
//	Product product3;
//	Product product4;
//	
//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {	
//	}
//
//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//	}
//
//	@BeforeEach
//	void setUp() throws Exception {
//		productList = new ArrayList<>();
//		product1 = new Product(1,300,20,Type.PLANTER);
//		product2 = new Product(2,100,8,Type.PLANTER);
//		product3 = new Product(3,277,12,Type.PLANTER);
//		product4 = new Product(1,180,18,Type.PLANTER);
//		productList.add(product1);
//		productList.add(product2);
//		productList.add(product3);
//		productList.add(product4);
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//	}
//
//	/*
//	 * @Test void test() { fail("Not yet implemented"); }
//	 */
//	
//	@Test
//	public void viewAllPlantersTest() {
//		when(dao.findAll()).thenReturn(productList);
//		assertEquals(4, service.getProducts().size());
//	}
//	
//	@Test
//	public void addPlanterTest() {
//		when(dao.save(product1)).thenReturn(product1);
//		assertEquals(product1, service.addProduct(product1));
//	}
//	
//	@Test
//	public void deleteProductTest() {
//		when(dao.findById(product1.getId())).thenReturn(Optional.of(product1));
//		assertEquals(product1.getStock()-1, service.deleteProduct(product1).getStock());
//	}
//	
//	@Test
//	public void viewPlanterTest() {
//		when(dao.findById(product1.getId())).thenReturn(Optional.of(product1));
//		assertEquals(product1, service.getProductById(product1.getId()));
//	}
//	
//	@Test
//	public void updatePlanterTest() {
//		when(dao.findById(product1.getId())).thenReturn(Optional.of(product4));
//		assertEquals(product4, service.updateProduct(product1));;
//	}
//	
//	
//	@Test
//	public void viewProductsInRangeTest() {
//		List<Product> newList = new ArrayList<>();
//		newList.add(product2);
//		newList.add(product4);
//		when(dao.findAll()).thenReturn(newList);
//		assertEquals(2, service.getProducts(200,400).size());
//	}
//	
//	@Test
//	public void costLowToHighTest() {
//		List<Product> sortedList = new ArrayList<>();
//		sortedList.add(product1);
//		sortedList.add(product3);
//		sortedList.add(product2);
//		sortedList.add(product4);
//		
//		when(dao.findAll()).thenReturn(sortedList);
//		assertEquals(sortedList, service.costLowToHigh());
//	}
//		
//}
