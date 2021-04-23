package com.cg.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.sprint1_onlineplantnursery.entity.Type;
import com.cg.sprint1_onlineplantnursery.entity.Seed;
import com.cg.sprint1_onlineplantnursery.entity.BloomTime;
import com.cg.sprint1_onlineplantnursery.entity.Difficulty;
import com.cg.sprint1_onlineplantnursery.exception.SeedIdNotFoundException;
import com.cg.sprint1_onlineplantnursery.repository.ISeedRepository;
import com.cg.sprint1_onlineplantnursery.service.SeedServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class SeedServiceTest {

	@Mock
	ISeedRepository seedRepoMock;
	
	@InjectMocks
	SeedServiceImpl seedServiceMock;
	
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
		seed1 = new Seed(12,20,8,Type.SEED,"Grape",BloomTime.MONSOON,"normal",Difficulty.EASY,"25 degree celcius","Vegetable","For Lemon",10);
//		seed2 = new Seed(20,5,Type.SEED,"Mango",BloomTime.MONSOON,"normal",Difficulty.MEDIUM,"25 degree celcius","Vegetable","For Lemon",10);
//		seed3 = new Seed(20,5,Type.SEED,"Apple",BloomTime.MONSOON,"normal",Difficulty.MEDIUM,"25 degree celcius","Vegetable","For Lemon",10);
		seedList.add(seed1);
		seedList.add(seed2);
		seedList.add(seed3);
	}
	
	@Test
	public void addSeedTest() {
		when(seedRepoMock.save(seed1)).thenReturn(seed1);
		assertEquals("Grape",seedServiceMock.addSeed(seed1).getName());
	}
	
	@Test
	public void updateSeedTest() {
		when(seedRepoMock.save(seed1)).thenReturn(seed1);
		assertEquals("Grape",seedServiceMock.addSeed(seed1).getName());
	}
	
	@Test
	public void getSeedByIdTest() {
		when(seedRepoMock.findById(12)).thenReturn(Optional.of(seed1));
		assertEquals(seed1,seedServiceMock.getSeed(12));
	}
	
	@Test
	public void getSeedByCommonNameTest() {
		when(seedRepoMock.findByName("Grape")).thenReturn(Optional.of(seed1));
		assertEquals(seed1,seedServiceMock.getSeed("Grape"));
	}
	
	@Test
	public void getSeedsTest() {
		when(seedRepoMock.findAll()).thenReturn(seedList);
		assertEquals(seedList.size(),seedServiceMock.getSeeds().size());
	}
	
	@Test
	public void getSeedsByTypeTest() {
//		Seed seed1 = new Seed(20,5,Type.SEED,"Apple",BloomTime.MONSOON,"normal",Difficulty.MEDIUM,"25 degree celcius","Fruit","For Lemon",10);
//		Seed seed2 = new Seed(20,5,Type.SEED,"Apple",BloomTime.MONSOON,"normal",Difficulty.MEDIUM,"25 degree celcius","Fruit","For Lemon",10);
		List<Seed> seedList = new ArrayList<>();
		seedList.add(seed1);
		seedList.add(seed2);
		when(seedRepoMock.findByTypeOfSeed("Fruit")).thenReturn(seedList);
		assertEquals(seedList.size(),seedServiceMock.getSeeds("Fruit").size());
	}
	
	@Test
	public void deleteSeedTest() {
		when(seedRepoMock.findById(12)).thenReturn(Optional.of(seed1));
		assertEquals("Grape",seedServiceMock.deleteSeed(seed1).getName());
	}
	
	@Test
	public void buySeedsTest() {
		when(seedRepoMock.findByName("Grape")).thenReturn(Optional.of(seed1));
		when(seedRepoMock.save(seed1)).thenReturn(seed1);
		assertEquals(3,seedServiceMock.buySeeds("Grape", 5).getStock());
		assertThrows(SeedIdNotFoundException.class, ()->seedServiceMock.buySeeds("Watermelon", 2));
	}
	
	@Test
	public void addStockTest() {
		when(seedRepoMock.findByName("Grape")).thenReturn(Optional.of(seed1));
		when(seedRepoMock.save(seed1)).thenReturn(seed1);
		assertEquals(13,seedServiceMock.addStock("Grape", 5).getStock());
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
		assertEquals(sortedList, seedServiceMock.costHighToLow());
	}
	
	
}