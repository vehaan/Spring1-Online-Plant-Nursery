package com.cg;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.cg.sprint1_onlineplantnursery.controller.SeedController;

@SpringBootTest
class Sprint1OnlinePlantNurseryApplicationTests {
	
	@Autowired
	SeedController seedController;

	@Test
	void contextLoads() {
		
		assertNotNull(seedController);
	}

}
