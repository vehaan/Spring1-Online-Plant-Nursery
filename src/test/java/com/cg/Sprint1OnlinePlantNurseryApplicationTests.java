package com.cg;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.sprint1_onlineplantnursery.entity.Plant;
import com.cg.sprint1_onlineplantnursery.repository.IPlantRepository;

@SpringBootTest
class Sprint1OnlinePlantNurseryApplicationTests {
	@Autowired
	private IPlantRepository plantRepo;
	@Test
	void contextLoads() {
	}
	@Test
	void test1() {
		//Plant plant2 = new Plant(2,1,"slow","Rose","winter","for beauty","hard","cold","herb","flowering-plant",5,7.0);
		Plant plant3 = new Plant(3,8,"fast","Lemon","summer","for lemons","easy","hot","shrub","fruit-plant",50,10.0);
		plantRepo.save(plant3);
		Plant pt = plantRepo.findByCommonName("Rose");
		System.out.println(pt.getMedicinalOrCulinaryUse());
	}

}
