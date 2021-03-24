package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.cg.sprint1_onlineplantnursery.entity.Plant;
// import com.cg.sprint1_onlineplantnursery.exception.PlantIdNotFoundException;

public interface IPlantService {
	Plant addNewPlant(Plant plant);
	
	Plant addPlantStock(String commonName, int stock);

	Plant updatePlant(Plant plant, int id);
	
	Plant partialUpdatePlant(Map<Object, Object> fields, int id);

	Plant deletePlant(Plant plant);
	
	Plant decreaseStock(int id, int stock);

	Plant getPlant(int plantId);

	Plant getPlant(String commonName);

	List<Plant> getAllPlants();

	List<Plant> getAllPlants(String typeOfPlant);
	
	List<Plant> costLowToHigh();
	
	List<Plant> costHighToLow();
	
	List<Plant> filterPlantByType(String type);
	
	List<Plant> filterPlantByDifficulty(String difficulty);
	
	String getBloomingStatus(int id);
}
