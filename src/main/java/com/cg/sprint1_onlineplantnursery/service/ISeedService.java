package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;
import java.util.Optional;
import com.cg.sprint1_onlineplantnursery.entity.Seed;

public interface ISeedService {
	
	Seed addSeed(Seed seed);
	Seed updateSeed(Seed seed);
	Seed deleteSeed(Seed seed);
	Optional<Seed> getSeed(int id);
	Seed getSeed(String commonName);
	List<Seed> getSeeds();
	List<Seed> getSeeds(String type);
	
}
