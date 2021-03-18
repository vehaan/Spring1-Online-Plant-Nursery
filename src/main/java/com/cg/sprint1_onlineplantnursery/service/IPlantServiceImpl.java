package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sprint1_onlineplantnursery.entity.Plant;
import com.cg.sprint1_onlineplantnursery.repository.IPlantRepository;

@Service
public class IPlantServiceImpl implements IPlantService{
	
	@Autowired
	private IPlantRepository plantRepo;
	
	
	@Override
	public Plant addPlant(Plant plant) {
		return plantRepo.save(plant);
	}


	@Override
	public Plant updatePlant(Plant plant) {
		return plantRepo.save(plant);
	}


	@Override
	public Plant deletePlant(Plant plant) {
		plantRepo.delete(plant);
		return plant;
	}


	@Override
	public Optional<Plant> viewPlant(int plantId) {
		return plantRepo.findById(plantId);
	}


	@Override
	public Plant viewPlant(String commonName) {
		return plantRepo.findByCommonName(commonName);
	}


	@Override
	public List<Plant> viewAllPlants() {
		return plantRepo.findAll();
	}


	@Override
	public List<Plant> viewAllPlants(String typeOfPlant) {
		return plantRepo.findByTypeOfPlant(typeOfPlant);
	
	}
	
	
	
}
