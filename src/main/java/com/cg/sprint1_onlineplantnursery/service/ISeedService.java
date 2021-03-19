package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;
import com.cg.sprint1_onlineplantnursery.entity.Seed;
import com.cg.sprint1_onlineplantnursery.exception.OutOfStockException;
import com.cg.sprint1_onlineplantnursery.exception.SeedIdNotFoundException;

public interface ISeedService {
	
	Seed addSeed(Seed seed);
	Seed updateSeed(Seed seed) throws SeedIdNotFoundException;
	Seed deleteSeed(Seed seed) throws SeedIdNotFoundException;
	Seed getSeed(int id) throws SeedIdNotFoundException;
	Seed getSeed(String commonName) throws SeedIdNotFoundException;
	List<Seed> getSeeds();
	List<Seed> getSeeds(String type);
	Seed addStock(String commonName, int stock) throws SeedIdNotFoundException;
	Seed buySeeds(String commonName,int stock) throws SeedIdNotFoundException, OutOfStockException;
	
}
