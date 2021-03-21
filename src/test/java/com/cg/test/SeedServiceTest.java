package com.cg.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.sprint1_onlineplantnursery.entity.Seed;
import com.cg.sprint1_onlineplantnursery.exception.SeedIdNotFoundException;
import com.cg.sprint1_onlineplantnursery.repository.ISeedRepository;
import com.cg.sprint1_onlineplantnursery.service.ISeedServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class SeedServiceTest {

	@Mock
	ISeedRepository seedRepoMock;
	
	@InjectMocks
	ISeedServiceImpl seedServiceMock;
	
	List<Seed> seedList;
	Seed seed1;
	Seed seed2;
	Seed seed3;
	Seed seed4;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception{
		seedList = new ArrayList<>();
		seed1 = new Seed(12,"Grape","2 days","normal","Easy","25 degree celcius","Vegetable","For Lemon",20,8,10);
		seed2 = new Seed(13,"Mango","2 days","normal","Medium","25 degree celcius","Vegetable","For Lemon",20,5,10);
		seed3 = new Seed(14,"Apple","2 days","normal","Easy","25 degree celcius","Vegetable","For Lemon",20,4,10);
		seedList.add(seed1);
		seedList.add(seed2);
		seedList.add(seed3);
	}
	
	@Test
	public void addSeedTest() {
		when(seedRepoMock.save(seed1)).thenReturn(seed1);
		assertEquals("Grape",seedServiceMock.addSeed(seed1).getCommonName());
	}
	
	@Test
	public void updateSeedTest() {
		when(seedRepoMock.save(seed1)).thenReturn(seed1);
		assertEquals("Grape",seedServiceMock.addSeed(seed1).getCommonName());
	}
	
	@Test
	public void getSeedByIdTest() {
		when(seedRepoMock.findById(12)).thenReturn(Optional.of(seed1));
		assertEquals(seed1,seedServiceMock.getSeed(12));
	}
	
	@Test
	public void getSeedByCommonNameTest() {
		when(seedRepoMock.findByCommonName("Grape")).thenReturn(Optional.of(seed1));
		assertEquals(seed1,seedServiceMock.getSeed("Grape"));
	}
	
	@Test
	public void getSeedsTest() {
		when(seedRepoMock.findAll()).thenReturn(seedList);
		assertEquals(seedList.size(),seedServiceMock.getSeeds().size());
	}
	
	@Test
	public void getSeedsByTypeTest() {
		Seed seed1 = new Seed(12,"Apple","2 days","normal","Easy","25 degree celcius","Vegetable","For Lemon",20,2,10);
		Seed seed2 = new Seed(13,"Apple","2 days","normal","Easy","25 degree celcius","Vegetable","For Lemon",20,2,10);
		List<Seed> seedList = new ArrayList<>();
		seedList.add(seed1);
		seedList.add(seed2);
		when(seedRepoMock.findByType("Apple")).thenReturn(seedList);
		assertEquals(seedList.size(),seedServiceMock.getSeeds("Apple").size());
	}
	
	@Test
	public void deleteSeedTest() {
		when(seedRepoMock.findById(12)).thenReturn(Optional.of(seed1));
		assertEquals("Grape",seedServiceMock.deleteSeed(seed1).getCommonName());
	}
	
	@Test
	public void buySeedsTest() {
		when(seedRepoMock.findByCommonName("Grape")).thenReturn(Optional.of(seed1));
		when(seedRepoMock.save(seed1)).thenReturn(seed1);
		assertEquals(15,seedServiceMock.buySeeds("Grape", 5).getStock());
		assertThrows(SeedIdNotFoundException.class, ()->seedServiceMock.buySeeds("Watermelon", 2));
	}
	
	@Test
	public void addStockTest() {
		when(seedRepoMock.findByCommonName("Grape")).thenReturn(Optional.of(seed1));
		when(seedRepoMock.save(seed1)).thenReturn(seed1);
		assertEquals(25,seedServiceMock.addStock("Grape", 5).getStock());
		assertThrows(SeedIdNotFoundException.class, ()->seedServiceMock.buySeeds("Watermelon", 2));
	}
	
	@Test
	public void costLowToHighTest() {
		List<Seed> sortedList = new ArrayList<>();
		sortedList.add(seed3);
		sortedList.add(seed2);
		sortedList.add(seed1);		
		when(seedRepoMock.findAll()).thenReturn(sortedList);
		assertEquals(sortedList, seedServiceMock.costLowToHigh());
	}
	
	@Test
	public void costHighToLowTest() {
		List<Seed> sortedList = new ArrayList<>();
		sortedList.add(seed1);
		sortedList.add(seed2);
		sortedList.add(seed3);		
		when(seedRepoMock.findAll()).thenReturn(sortedList);
		assertEquals(sortedList, seedServiceMock.costLowToHigh());
	}
	
	
}
