package com.cg.sprint1_onlineplantnursery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.sprint1_onlineplantnursery.entity.Plant;




@Repository
public interface IPlantRepository extends JpaRepository<Plant, Integer>{
	
	Optional<Plant> findByCommonName(String commonName);
	
	List<Plant> findByTypeOfPlant(String typeOfPlant);
}
