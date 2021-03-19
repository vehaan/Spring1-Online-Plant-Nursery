package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;
import java.util.Optional;
import com.cg.sprint1_onlineplantnursery.entity.Seed;
import com.cg.sprint1_onlineplantnursery.exception.SeedIdNotFoundException;

public interface ISeedService {
	
	Seed addSeed(Seed seed);
	Seed updateSeed(Seed seed);
	Seed deleteSeed(Seed seed);
	Seed getSeed(int id) throws SeedIdNotFoundException;
	Seed getSeed(String commonName);
	List<Seed> getSeeds();
	List<Seed> getSeeds(String type);
	
}
