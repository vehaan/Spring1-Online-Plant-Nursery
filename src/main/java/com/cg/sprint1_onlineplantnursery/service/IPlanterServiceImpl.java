package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.sprint1_onlineplantnursery.entity.Planter;
import com.cg.sprint1_onlineplantnursery.exception.ResourceNotFoundException;
import com.cg.sprint1_onlineplantnursery.repository.IPlanterRepository;

@Service 
public class IPlanterServiceImpl implements IPlanterService {
	
	@Autowired
	IPlanterRepository iplanterRepo;
		
	@Override
	public Planter addPlanter(Planter planter) {
		if (planter.getId() == null)
			return iplanterRepo.save(planter);
		Optional<Planter> optionalPlanter = iplanterRepo.findById(planter.getId()); //if not present gives NoSuchElementException. If id is null then IllegalArgumentException. So tackle that  
		if (optionalPlanter.isPresent()) {
			Planter p = optionalPlanter.get();
			p.setStock(p.getStock()+1);
			return iplanterRepo.save(p);
		}else {
			return iplanterRepo.save(planter);
		}
	}

	@Override
	public Planter deletePlanter(Planter planter) throws ResourceNotFoundException{
		Optional<Planter> optionalPlanter = iplanterRepo.findById(planter.getId()); //if not present gives NoSuchElementException. If id is null then IllegalArgumentException. So tackle that  
		if (optionalPlanter.isPresent()) {
			Planter p = optionalPlanter.get();
			p.setStock(p.getStock()-1);
			if (p.getStock() < 1)
				iplanterRepo.delete(p);
			else
				iplanterRepo.save(p);
		}
		return optionalPlanter.orElseThrow(() -> new ResourceNotFoundException("The planter with given id does not exist"));
	}
	
	@Override
	public Planter deleteEntireStock(int id) throws ResourceNotFoundException{
		Optional<Planter> optionalPlanter = iplanterRepo.findById(id); //if not present gives NoSuchElementException. If id is null then IllegalArgumentException. So tackle that  
		if (optionalPlanter.isPresent()) {
			Planter p = optionalPlanter.get();
			iplanterRepo.delete(p);
			
		}
		return optionalPlanter.orElseThrow(() -> new ResourceNotFoundException("The stock for planter with given id does not exist"));
	}
	
	@Override
	public Planter viewPlanter(int id) throws ResourceNotFoundException {
		Optional<Planter> optionalPlanter =  iplanterRepo.findById(id); //if not present gives NoSuchElementException. If id is null then IllegalArgumentException. So tackle that  
		return optionalPlanter.orElseThrow(() -> new ResourceNotFoundException("Planter does not exist with given id"));
	}


	@Override
	public List<Planter> viewAllPlanters() {
		return iplanterRepo.findAll();
	}

	@Override
	public List<Planter> viewAllPlanters(double minCost, double maxCost) {
		List<Planter> allPlanters = iplanterRepo.findAll();
		List<Planter> requiredPlanters = allPlanters.stream().filter((p) -> p.getCost() >minCost && p.getCost() < maxCost).collect(Collectors.toList());
		return requiredPlanters;
	}

	@Override
	public List<Planter> viewPlantersByShape(String planterShape) {
		List<Planter> allPlanters = iplanterRepo.findAll();
		List<Planter> requiredPlanters = allPlanters.stream().filter((p) -> p.getShape().equals(planterShape)).collect(Collectors.toList());
		return requiredPlanters;
			
	}

	@Override
	public Planter updatePlanter(Planter planter) throws ResourceNotFoundException {
		Optional<Planter> optionalPlanter = iplanterRepo.findById(planter.getId()); //if not present gives NoSuchElementException. If id is null then IllegalArgumentException. So tackle that and 
		if (optionalPlanter.isPresent()) {
			Planter p = optionalPlanter.get();
			p.setColor(planter.getColor());
			p.setDrainageHoles(planter.getDrainageHoles());
			p.setCapacity(planter.getCapacity());
			p.setCost(planter.getCost());
			p.setHeight(planter.getHeight());
			p.setShape(planter.getShape());
			p.setStock(planter.getStock());
			iplanterRepo.save(p);
		}
		return iplanterRepo.findById(planter.getId()).orElseThrow(() -> new ResourceNotFoundException("Planter with given id does not exist. So update can not be done"));
	}
	
}