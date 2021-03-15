package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.sprint1_onlineplantnursery.entity.Seed;

@Service
public interface ISeedService {
	Seed addSeed(Seed seed);

	Seed updateSeed(Seed seed);

	Seed deleteSeed(Seed seed);

	Optional<Seed> viewSeed(int seedId);

	Seed viewSeed(String commonName);

	List<Seed> viewAllSeeds();

	List<Seed> viewAllSeeds(String typeOfSeed);
}
