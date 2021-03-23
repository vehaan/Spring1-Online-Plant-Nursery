package com.cg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.sprint1_onlineplantnursery.entity.Plant;
import com.cg.sprint1_onlineplantnursery.entity.Plant.BloomTime;
import com.cg.sprint1_onlineplantnursery.entity.Plant.Difficulty;
import com.cg.sprint1_onlineplantnursery.exception.PlantIdNotFoundException;
import com.cg.sprint1_onlineplantnursery.repository.IPlantRepository;
import com.cg.sprint1_onlineplantnursery.service.IPlantServiceImpl;





@TestMethodOrder(OrderAnnotation.class) 
@SpringBootTest
//@RunWith(SpringRunner.class)
@RunWith(MockitoJUnitRunner.class)
class PlantTest {

	@Mock
	IPlantRepository plantRepoMock;
	
	@InjectMocks
	IPlantServiceImpl plantServiceMock;
	
	static Plant plant1;
	static Plant plant2;
	static Plant plant3;
	static List<Plant> plants = new ArrayList<>();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		plant1 = new Plant(11,5,"fast",BloomTime.WINTER,"for beauty", Difficulty.EASY,"warm","herb","Jasmine","flowering-plant",30,5.0);
		plant2 = new Plant(12,5,"fast",BloomTime.SUMMER,"for beauty", Difficulty.HARD,"warm","herb","Mango","flowering-plant",30,5.0);
		plant3 = new Plant(13,5,"fast",BloomTime.AUTUMN,"for beauty", Difficulty.HARD,"warm","shrub","Banana","flowering-plant",30,5.0);

		plant3 = new Plant();
		plants.add(plant2);
		plants.add(plant3);
	}
	
	@BeforeEach
	void setUp() throws Exception {

	}
	@Order(1)
	//@Disabled
	@Test
	public void addNewPlantTest() {
		when(plantRepoMock.save(plant1)).thenReturn(plant1);
		assertEquals("Jasmine",plantServiceMock.addNewPlant(plant1).getCommonName());	
	}
	@Order(2)
	//@Disabled
	@Test
	public void addPlantStockTest(){
		
		when(plantRepoMock.findByCommonName("Mango")).thenReturn(Optional.of(plant2));
		assertEquals("32",plantServiceMock.addPlantStock("Mango", 2).getStock().toString());
		
		//trying to add stock to a plant which does not exists
		assertThrows(PlantIdNotFoundException.class,()-> plantServiceMock.addPlantStock("jaj", 2)); 
	}
	@Order(3)
	//@Disabled
	@Test
	public void decreasePlantStockTest(){
		
		when(plantRepoMock.findByCommonName("Jasmine")).thenReturn(Optional.of(plant1));
		assertEquals("28",plantServiceMock.decreaseStock(11, 2).getStock().toString());
		
		//trying to add stock to a plant which does not exists
		assertThrows(PlantIdNotFoundException.class,()-> plantServiceMock.decreaseStock(909, 2)); 
	}
	@Order(4)
	//@Disabled
	@Test
	public void updatePlantTest() {
		when(plantRepoMock.findById(11)).thenReturn(Optional.of(plant1));
		Plant plant1Update = new Plant(11,10,"fast",BloomTime.WINTER,"for beauty", Difficulty.EASY,"warm","herb","Jasmine","flowering-plant",30,5.0);
		//updating height 5 to 10
		assertEquals("10", plantServiceMock.updatePlant(plant1Update, 11).getHeight().toString());
		
	}
	@Order(5)
	//@Disabled
	@Test
	public void deletePlantTest() {
		when(plantRepoMock.findById(11)).thenReturn(Optional.of(plant1));
		//when(plantRepoMock.(plant1)).thenReturn(plant1);
		
		assertEquals("Jasmine",plantServiceMock.deletePlant(plant1).getCommonName());
	}
	@Order(6)
	//@Disabled
	@Test
	public void getPlantwithIdTest() {
		
		when(plantRepoMock.findById(11)).thenReturn(Optional.of(plant1));
		
		assertEquals(plant1,plantServiceMock.getPlant(11));
		Exception exception = assertThrows(PlantIdNotFoundException.class,()->plantServiceMock.getPlant(1));
		assertTrue(exception.getMessage().contains("Plant Not Found"));
	}
	@Order(7)
	//@Disabled
	@Test
	public void getPlantwithCommonNameTest() {
		
		when(plantRepoMock.findByCommonName("Jasmine")).thenReturn(Optional.of(plant1));
		
		assertEquals(plant1,plantServiceMock.getPlant("Jasmine"));
		Exception exception = assertThrows(PlantIdNotFoundException.class,()->plantServiceMock.getPlant(1));
		assertTrue(exception.getMessage().contains("Plant Not Found"));
	}
	
	@Order(8)
	//@Disabled
	@Test
	public void getAllPlants() {
		when(plantRepoMock.findAll()).thenReturn(plants);		
		assertEquals(3,plantServiceMock.getAllPlants().size());
	}
	
	@Order(9)
	//@Disabled
	@Test
	public void getAllPlantsByType() {
		List<Plant> list = new ArrayList<>();
		list.add(plant1);
		list.add(plant2);
		when(plantRepoMock.findByTypeOfPlant("herb")).thenReturn(list);		
		assertEquals(2,plantServiceMock.getAllPlants("herb").size());
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
