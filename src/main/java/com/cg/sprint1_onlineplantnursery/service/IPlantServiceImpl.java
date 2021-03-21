package com.cg.sprint1_onlineplantnursery.service;


import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.cg.sprint1_onlineplantnursery.entity.Plant;
import com.cg.sprint1_onlineplantnursery.exception.PlantIdNotFoundException;
import com.cg.sprint1_onlineplantnursery.repository.IPlantRepository;
@Transactional
@Service
public class IPlantServiceImpl implements IPlantService{
	
	@Autowired
	private IPlantRepository plantRepo;
	
	
	@Override
	public Plant addNewPlant(Plant plant) {
		plantRepo.save(plant);	
		return plant;
	}
	
	@Override
	public Plant addPlantStock(String commonName, int stock){
			
		Optional<Plant> plantOptional = plantRepo.findByCommonName(commonName);
		if(plantOptional.isPresent()) {
			Plant plant = plantOptional.get();
			int newStock = plant.getStock()+stock;
			plant.setStock(newStock);
			plantRepo.save(plant); 
			return plant;
		}
		return plantOptional.orElseThrow(() -> new PlantIdNotFoundException("Plant Not Found"));
	}


	@Override
	public Plant updatePlant(Plant plant, int id){
		Optional<Plant> plantOptional = plantRepo.findById(id);
		if(plantOptional.isPresent()) {
			Plant plantToBeUpdated = plantOptional.get();
			plantToBeUpdated.setBloomTime(plant.getBloomTime());
			plantToBeUpdated.setCommonName(plant.getCommonName());
			plantToBeUpdated.setCost(plant.getCost());
			plantToBeUpdated.setDescription(plant.getDescription());
			plantToBeUpdated.setDifficultyLevel(plant.getDifficultyLevel());
			plantToBeUpdated.setHeight(plant.getHeight());
			plantToBeUpdated.setMedicinalOrCulinaryUse(plant.getMedicinalOrCulinaryUse());
			plantToBeUpdated.setSpread(plant.getSpread());
			plantToBeUpdated.setStock(plant.getStock());
			plantToBeUpdated.setTemparature(plant.getTemparature());
			plantToBeUpdated.setTypeOfPlant(plant.getTypeOfPlant());
			plantRepo.save(plantToBeUpdated);
			return plantToBeUpdated;
			
		}
		return plantOptional.orElseThrow(() -> new PlantIdNotFoundException("Plant Not Found"));
	}
	



	@Override
	public Plant partialUpdatePlant(Map<Object, Object> fields, int id){
		
		Optional<Plant> plantOptional = plantRepo.findById(id);
		if(plantOptional.isPresent()) {
		
			Plant plant = plantRepo.findById(id).get();
			fields.forEach((k,v)->{
				Field field = ReflectionUtils.findRequiredField(Plant.class, (String)k);
				field.setAccessible(true);
				ReflectionUtils.setField(field, plant, v);	
			});
			return plantRepo.save(plant);
		}
		return plantOptional.orElseThrow(() -> new PlantIdNotFoundException("Plant Not Found"));
	}

	@Override
	public Plant deletePlant(Plant plant){
		
		Optional<Plant> plantOptional = plantRepo.findById(plant.getId());
		
		if(plantOptional.isPresent()) {
			Plant here = plantOptional.get();
			plantRepo.delete(here);
			return here;
		}
		return plantOptional.orElseThrow(() -> new PlantIdNotFoundException("Plant Not Found"));
	}
	@Override
	public Plant decreaseStock(String commonName, int stock) {
		Optional<Plant> plantOptional = plantRepo.findByCommonName(commonName);
		if(plantOptional.isPresent()) {
			Plant plant = plantOptional.get();
			int newStock = plant.getStock()-stock;
			plant.setStock(newStock);
			plantRepo.save(plant); 
			return plant;
		}
		return plantOptional.orElseThrow(() -> new PlantIdNotFoundException("Plant Not Found"));
	}



	@Override
	public Plant getPlant(int plantId){
		Optional<Plant> plantOptional = plantRepo.findById(plantId);
		if(plantOptional.isPresent()) {
			
			return plantRepo.findById(plantId).get();
		}
		
		return plantOptional.orElseThrow(() -> new PlantIdNotFoundException("Plant Not Found"));
	}


	@Override
	public Plant getPlant(String commonName){
		Optional<Plant> plantOptional = plantRepo.findByCommonName(commonName);
		if(plantOptional.isPresent()) {
			Plant plant = plantOptional.get();
			return plant;
		}
		return plantOptional.orElseThrow(() -> new PlantIdNotFoundException("Plant Not Found"));
	}


	@Override
	public List<Plant> getAllPlants() {
		return plantRepo.findAll();
	}


	@Override
	public List<Plant> getAllPlants(String typeOfPlant) {
		return plantRepo.findByTypeOfPlant(typeOfPlant);
	
	}










	
	
	
}
