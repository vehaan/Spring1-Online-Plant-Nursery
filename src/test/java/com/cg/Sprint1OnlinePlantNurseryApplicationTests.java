package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.sprint1_onlineplantnursery.entity.Seed;
import com.cg.sprint1_onlineplantnursery.entity.Seed.Difficulty;
import com.cg.sprint1_onlineplantnursery.exception.SeedIdNotFoundException;
import com.cg.sprint1_onlineplantnursery.repository.ISeedRepository;
import com.cg.sprint1_onlineplantnursery.service.ISeedServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class Sprint1OnlinePlantNurseryApplicationTests {

	@Mock
	ISeedRepository seedRepoMock;
	
	@InjectMocks
	ISeedServiceImpl seedServiceMock;
	
	@Test
	public void addSeedTest() {
		Seed seedTest = new Seed(12,"Grape","2 days","normal",Difficulty.EASY,"25 degree celcius","Vegetable","For Lemon",20,2,10);
		when(seedRepoMock.save(seedTest)).thenReturn(seedTest);
		assertEquals("Grape",seedServiceMock.addSeed(seedTest).getCommonName());
	}
	
	@Test
	public void updateSeedTest() {
		Seed seedTest = new Seed(12,"Grape","2 days","normal",Difficulty.EASY,"25 degree celcius","Vegetable","For Lemon",20,2,10);
		when(seedRepoMock.save(seedTest)).thenReturn(seedTest);
		assertEquals("Grape",seedServiceMock.addSeed(seedTest).getCommonName());
	}
	
	@Test
	public void getSeedByIdTest() {
		Optional<Seed> seedTest = Optional.of(new Seed(11,"XYZ","2 days","normal",Difficulty.EASY,"25 degree celcius","Vegetable","For Lemon",20,2,10));
		when(seedRepoMock.findById(11)).thenReturn(seedTest);
		assertEquals(seedTest.get(),seedServiceMock.getSeed(11));
	}
	
	@Test
	public void getSeedByCommonNameTest() {
		Optional<Seed> seedTest = Optional.of(new Seed(11,"XYZ","2 days","normal",Difficulty.EASY,"25 degree celcius","Vegetable","For Lemon",20,2,10));
		when(seedRepoMock.findByCommonName("XYZ")).thenReturn(seedTest);
		assertEquals(seedTest.get(),seedServiceMock.getSeed("XYZ"));
	}
	
	@Test
	public void getSeedsTest() {
		Seed seed1 = new Seed(12,"Apple","2 days","normal",Difficulty.EASY,"25 degree celcius","Vegetable","For Lemon",20,2,10);
		Seed seed2 = new Seed(13,"Watermelon","2 days","normal",Difficulty.EASY,"25 degree celcius","Vegetable","For Lemon",20,2,10);
		Seed seed3 = new Seed(14,"Grapes","2 days","normal",Difficulty.EASY,"25 degree celcius","Vegetable","For Lemon",20,2,10);
		List<Seed> seedList = new ArrayList<>();
		seedList.add(seed1);
		seedList.add(seed2);
		seedList.add(seed3);
		when(seedRepoMock.findAll()).thenReturn(seedList);
		assertEquals(seedList.size(),seedServiceMock.getSeeds().size());
	}
	
	@Test
	public void getSeedsByTypeTest() {
		Seed seed1 = new Seed(12,"Apple","2 days","normal",Difficulty.EASY,"25 degree celcius","Vegetable","For Lemon",20,2,10);
		Seed seed2 = new Seed(13,"Apple","2 days","normal",Difficulty.EASY,"25 degree celcius","Vegetable","For Lemon",20,2,10);
		List<Seed> seedList = new ArrayList<>();
		seedList.add(seed1);
		seedList.add(seed2);
		when(seedRepoMock.findByType("Apple")).thenReturn(seedList);
		assertEquals(seedList.size(),seedServiceMock.getSeeds("Apple").size());
	}
	
	@Test
	public void deleteSeedTest() {
		Seed seed1 = new Seed(12,"Apple","2 days","normal",Difficulty.EASY,"25 degree celcius","Vegetable","For Lemon",20,2,10);
		Seed seed2 = new Seed(13,"Grape","2 days","normal",Difficulty.EASY,"25 degree celcius","Vegetable","For Lemon",20,2,10);
		List<Seed> seedList = new ArrayList<>();
		seedList.add(seed1);
		seedList.add(seed2);
		when(seedRepoMock.save(seed1)).thenReturn(seed1);
		when(seedRepoMock.save(seed2)).thenReturn(seed2);
	}
	
	@Test
	public void buySeedsTest() {
		Optional<Seed> seed = Optional.of(new Seed(12,"Apple","2 days","normal",Difficulty.EASY,"25 degree celcius","Vegetable","For Lemon",20,2,10));
		when(seedRepoMock.findByCommonName("Apple")).thenReturn(seed);
		when(seedRepoMock.save(seed.get())).thenReturn(seed.get());
		assertEquals(15,seedServiceMock.buySeeds("Apple", 5).getStock());
		assertThrows(SeedIdNotFoundException.class, ()->seedServiceMock.buySeeds("Watermelon", 2));
	}
	
	@Test
	public void addStockTest() {
		Optional<Seed> seed = Optional.of(new Seed(12,"Apple","2 days","normal",Difficulty.EASY,"25 degree celcius","Vegetable","For Lemon",20,2,10));
		when(seedRepoMock.findByCommonName("Apple")).thenReturn(seed);
		when(seedRepoMock.save(seed.get())).thenReturn(seed.get());
		assertEquals(25,seedServiceMock.addStock("Apple", 5).getStock());
		assertThrows(SeedIdNotFoundException.class, ()->seedServiceMock.buySeeds("Watermelon", 2));
	}
	
}
