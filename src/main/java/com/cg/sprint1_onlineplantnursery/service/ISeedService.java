package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;
import java.util.Map;
import com.cg.sprint1_onlineplantnursery.entity.Seed;
import com.cg.sprint1_onlineplantnursery.entity.Seed.BloomTime;
import com.cg.sprint1_onlineplantnursery.entity.Seed.Difficulty;

public interface ISeedService {
	
	Seed addSeed(Seed seed);
	Seed updateSeed(Seed seed);
	Seed deleteSeed(Seed seed);
	Seed getSeed(int id);
	Seed getSeed(String commonName);
	List<Seed> getSeeds();
	List<Seed> getSeeds(String type);
	Seed addStock(String commonName, int stock);
	Seed buySeeds(String commonName,int stock);
	List<Seed> costLowToHigh();
	List<Seed> costHighToLow();
	List<Seed> filterSeedByBloomTime(BloomTime bloomTime);
	Seed buySeeds(int id, int stock);
	Seed updateSeed(int id, Map<Object, Object> fields);
	List<Seed> filterSeedByDifficulty(Difficulty difficultyLevel);
	Seed deleteSeedById(int id);

	
}
