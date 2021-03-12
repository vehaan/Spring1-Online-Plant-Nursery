package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;

import com.cg.sprint1_onlineplantnursery.entity.Seed;

public interface ISeedService {
	Seed addSeed(Seed seed);

	Seed updateSeed(Seed seed);

	Seed deleteSeed(Seed seed);

	Seed viewSeed(int seedId);

	Seed viewSeed(String commonName);

	List<Seed> viewAllSeeds();

	List<Seed> viewAllSeeds(String typeOfSeed);
}
