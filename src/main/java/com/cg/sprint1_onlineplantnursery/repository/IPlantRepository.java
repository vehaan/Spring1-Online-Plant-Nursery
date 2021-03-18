package com.cg.sprint1_onlineplantnursery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.sprint1_onlineplantnursery.entity.Plant;




@Repository
public interface IPlantRepository extends JpaRepository<Plant, Integer>{
	
	Plant findByCommonName(String commonName);
	
	List<Plant> findByTypeOfPlant(String typeOfPlant);
}
