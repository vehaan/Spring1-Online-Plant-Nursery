package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;
import java.util.Optional;

import com.cg.sprint1_onlineplantnursery.entity.Plant;

public interface IPlantService {
	Plant addPlant(Plant plant);

	Plant updatePlant(Plant plant);

	Plant deletePlant(Plant plant);

	Optional<Plant> viewPlant(int plantId);

	Plant viewPlant(String commonName);

	List<Plant> viewAllPlants();

	List<Plant> viewAllPlants(String typeOfPlant);
}
