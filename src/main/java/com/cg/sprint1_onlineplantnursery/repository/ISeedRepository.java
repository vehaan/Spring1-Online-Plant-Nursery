package com.cg.sprint1_onlineplantnursery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.sprint1_onlineplantnursery.entity.Seed;

public interface ISeedRepository extends JpaRepository<Seed, Integer>{
	Seed findByCommonName(String commonName);
	List<Seed> findByTypeOfSeeds(String typeOfSeeds);
//	Seed addSeed(Seed seed);
//
//	Seed updateSeed(Seed seed);
//
//	Seed deleteSeed(Seed seed);
//
//	Seed viewSeed(int seedId);
//
//	Seed viewSeed(String commonName);
//
//	List<Seed> viewAllSeeds();
//
//	List<Seed> viewAllSeeds(String typeOfSeed);
}
