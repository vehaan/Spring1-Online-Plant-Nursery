package com.cg.sprint1_onlineplantnursery.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;
import com.cg.sprint1_onlineplantnursery.entity.Planter;
import com.cg.sprint1_onlineplantnursery.entity.Seed;
import com.cg.sprint1_onlineplantnursery.exception.InsufficientStockException;
import com.cg.sprint1_onlineplantnursery.exception.ResourceNotFoundException;
import com.cg.sprint1_onlineplantnursery.repository.IPlanterRepository;

@Service 
public class IPlanterServiceImpl implements IPlanterService {
	
	@Autowired
	IPlanterRepository planterRepo;
	
	@Autowired
	ISeedService seedService;
		
	@Override
	public Planter addPlanter(Planter planter) {
		if (planter.getId() == 0)
			return planterRepo.save(planter);
		Optional<Planter> optionalPlanter = planterRepo.findById(planter.getId()); 
		if (optionalPlanter.isPresent()) {
			Planter p = optionalPlanter.get();
			p.setStock(p.getStock()+1);
			return planterRepo.save(p);
		}else {
			return planterRepo.save(planter);
		}
	}

	@Override
	public Planter deletePlanter(Planter planter) {
		Optional<Planter> optionalPlanter = planterRepo.findById(planter.getId()); 
		if (optionalPlanter.isPresent()) {
			Planter p = optionalPlanter.get();
			p.setStock(p.getStock()-1);
			if (p.getStock() < 0)
				throw new InsufficientStockException("Stock is insufficient");
				planterRepo.save(p);
		}
		return optionalPlanter.orElseThrow(() -> new ResourceNotFoundException("The planter with given id does not exist"));
	}
	
	@Override
	public Planter deletePlanterById(int id) {
		Optional<Planter> optionalPlanter = planterRepo.findById(id); 
		if (optionalPlanter.isPresent()) {
			Planter p = optionalPlanter.get();
			p.setStock(p.getStock()-1);
				planterRepo.save(p);
		}
		return optionalPlanter.orElseThrow(() -> new ResourceNotFoundException("The planter with given id does not exist"));
	}
	
	@Override
	public Planter getPlanter(int id) {
		Optional<Planter> optionalPlanter =  planterRepo.findById(id); 
		return optionalPlanter.orElseThrow(() -> new ResourceNotFoundException("Planter does not exist with given id"));
	}


	@Override
	public List<Planter> getPlanters() {
		return planterRepo.findAll();
	}
	
	@Override
	public Planter updatePlanter(Planter planter) {
		//id must be given
		Optional<Planter> optionalPlanter = planterRepo.findById(planter.getId());  
		if (optionalPlanter.isPresent()) {
			//not null check
			/*
			 * Planter p = optionalPlanter.get(); p.setColor(planter.getColor());
			 * p.setDrainageHoles(planter.getDrainageHoles());
			 * p.setCapacity(planter.getCapacity()); p.setCost(planter.getCost());
			 * p.setHeight(planter.getHeight()); p.setShape(planter.getShape());
			 * p.setStock(planter.getStock());
			 */
			planterRepo.save(planter);
		}
		return planterRepo.findById(planter.getId()).orElseThrow(() -> new ResourceNotFoundException("Planter with given id does not exist. So, update can not be done"));
	}
	
	@Override
	public Planter partialUpdatePlanter(Map<Object,Object> fields, int id) {
		Optional<Planter> optionalPlanter = planterRepo.findById(id);
		if (optionalPlanter.isPresent()) {
			Planter planter  = optionalPlanter.get();
			fields.forEach((k,v) -> {
				Field field = ReflectionUtils.findRequiredField(Planter.class, (String)k);
				field.setAccessible(true);
				ReflectionUtils.setField(field, planter, v);
			});
			return planterRepo.save(planter);
		}
		return optionalPlanter.orElseThrow(() -> new ResourceNotFoundException("Planter with given id does not exist. So, patch can not be done."));
	}
	
	
	//ADD A SERVICE FOR PATCH HERE
	
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Override
	public List<Planter> getPlanters(double minCost, double maxCost) {
		List<Planter> allPlanters = planterRepo.findAll();
		List<Planter> requiredPlanters = allPlanters.stream().filter((p) -> p.getCost() >minCost && p.getCost() < maxCost).collect(Collectors.toList());
		return requiredPlanters;
	}
	
	@Override
	public List<Planter> deletePlanters() {
		List<Planter> allPlanters = planterRepo.findAll();
		allPlanters.stream().forEach((p) -> planterRepo.delete(p));
		return planterRepo.findAll();
	}
	
	@Override
	public Planter removePlanterStock(Planter planter,int quantity) {
		Optional<Planter> optionalPlanter = planterRepo.findById(planter.getId()); 
		if (optionalPlanter.isPresent()) {
			Planter p = optionalPlanter.get();
			if (p.getStock()-quantity < 0)
				throw new InsufficientStockException("Insufficient Stock");
				
			p.setStock(p.getStock() - quantity);
			if (p.getStock() == 0)
				planterRepo.delete(p);
			else
				planterRepo.save(p);
		}
		return optionalPlanter.orElseThrow(() -> new ResourceNotFoundException("The planter with given id does not exist"));
	}
	
	@Override
	public Planter addPlanterStock(int id, int quantity) {
		//id must be given
		Optional<Planter> optionalPlanter = planterRepo.findById(id);  
		if (optionalPlanter.isPresent()) {
			//not null check
			/*
			 * Planter p = optionalPlanter.get(); p.setColor(planter.getColor());
			 * p.setDrainageHoles(planter.getDrainageHoles());
			 * p.setCapacity(planter.getCapacity()); p.setCost(planter.getCost());
			 * p.setHeight(planter.getHeight()); p.setShape(planter.getShape());
			 * p.setStock(planter.getStock());
			 */
			Planter p = optionalPlanter.get();
			p.setStock(p.getStock()+quantity);
			planterRepo.save(p);
		}
		return planterRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Planter with given id does not exist. So, update can not be done"));
	}
	
	//SORTBY
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public List<Planter> costLowToHigh() {
		List<Planter> allPlanters = planterRepo.findAll();
		List<Planter> sortedPlanters = allPlanters.stream().sorted((Planter o1,Planter o2) -> o1.getCost() - o2.getCost()).collect(Collectors.toList());
		return sortedPlanters;
	}
	
	@Override
	public List<Planter> costHighToLow() {
		List<Planter> allPlanters = planterRepo.findAll();
		List<Planter> sortedPlanters = allPlanters.stream().sorted((Planter o1,Planter o2) -> o2.getCost() - o1.getCost()).collect(Collectors.toList());
		return sortedPlanters;
	}
	
	
	//FILTER
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public List<Planter> filterPlantersByColor(String color) {
		List<Planter> allPlanters = planterRepo.findAll();
		List<Planter> requiredPlanters = allPlanters.stream().filter((p) -> p.getColor().equals(color)).collect(Collectors.toList());
		return requiredPlanters;
			
	}
	
	@Override
	public List<Planter> filterPlantersByShape(String shape) {
		List<Planter> allPlanters = planterRepo.findAll();
		List<Planter> requiredPlanters = allPlanters.stream().filter((p) -> p.getShape().equals(shape)).collect(Collectors.toList());
		return requiredPlanters;
			
	}
	
	@Override
	public List<Planter> filterPlantersByHeight(float height) {
		List<Planter> allPlanters = planterRepo.findAll();
		List<Planter> requiredPlanters = allPlanters.stream().filter((p) -> p.getHeight() == height).collect(Collectors.toList());
		return requiredPlanters;
			
	}
	
	@Override
	public List<Planter> filterPlantersByCapacity(int capacity) {
		List<Planter> allPlanters = planterRepo.findAll();
		List<Planter> requiredPlanters = allPlanters.stream().filter((p) -> p.getCapacity() == capacity).collect(Collectors.toList());
		return requiredPlanters;
			
	}
	
	@Override
	public List<Planter> filterPlantersByDrainageHoles(int drainageHoles) {
		List<Planter> allPlanters = planterRepo.findAll();
		List<Planter> requiredPlanters = allPlanters.stream().filter((p) -> p.getDrainageHoles() == drainageHoles).collect(Collectors.toList());
		return requiredPlanters;
			
	}
	
//	WITH SEED SERVICES
//-----------------------------------------------------------------------------------------------------------------------------------------------------
	

//	@Override
//	public Planter addCustomPlanter(int planterId, int seedId, int seedStock){
//		List<Seed> seedList = new ArrayList<>();
//		Planter planter = deletePlanterById(planterId);
//		Seed seed = seedService.buySeeds(seedId, seedStock);
//			seedList.add(seed);
//			planter.setSeeds(seedList);
//		return planter;
//	}

}