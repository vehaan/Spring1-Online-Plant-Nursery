package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.sprint1_onlineplantnursery.entity.Planter;
import com.cg.sprint1_onlineplantnursery.repository.IPlanterRepository;

@Service
public class IPlanterServiceImpl implements IPlanterService {
	
	@Autowired
	IPlanterRepository iplanterRepo;

	@Override
	public Planter addPlanter(Planter planter) {
		Optional<Planter> op = iplanterRepo.findById(planter.getPlanterId());
		if (op.isPresent()) {
			Planter p = op.get();
			p.setPlanterStock(p.getPlanterStock()+1);
			return iplanterRepo.save(p);
		}else {
			return iplanterRepo.save(planter);
		}
		
		
		
	}

	@Override
	public Planter deletePlanter(Planter planter) {
		Planter p = iplanterRepo.findById(planter.getPlanterId()).get();
		if (p != null) {
			p.setPlanterStock(p.getPlanterStock()-1);
			if (p.getPlanterStock() < 1)
				iplanterRepo.delete(p);
			else
				iplanterRepo.save(p);
		}
		return iplanterRepo.findById(planter.getPlanterId()).get();
	}

	@Override
	public Planter viewPlanter(int planterId) {
		return iplanterRepo.findById(planterId).get();
	}


	@Override
	public List<Planter> viewAllPlanters() {
		return iplanterRepo.findAll();
	}

	@Override
	public List<Planter> viewAllPlanters(double minCost, double maxCost) {
		List<Planter> allPlanters = iplanterRepo.findAll();
		List<Planter> requiredPlanters = allPlanters.stream().filter((p) -> p.getPlanterCost() >minCost && p.getPlanterCost() < maxCost).collect(Collectors.toList());
		/*
		 * for (Planter planter: requiredPlanters) { if (planter.getPlanterCost() <
		 * minCost || planter.getPlanterCost() > maxCost)
		 * requiredPlanters.remove(planter); }
		 */
		return requiredPlanters;
	}

	@Override
	public List<Planter> viewPlanter(String planterShape) {
		List<Planter> allPlanters = iplanterRepo.findAll();
		List<Planter> requiredPlanters = allPlanters.stream().filter((p) -> p.getPlanterShape().equals(planterShape)).collect(Collectors.toList());
		return requiredPlanters;
			
	}

	@Override
	public Planter updatePlanter(Planter planter) {
		Planter p = iplanterRepo.findById(planter.getPlanterId()).get();
		p.setPlanterColor("Purple"); //Hard coded for now
		iplanterRepo.save(p);
		return iplanterRepo.findById(planter.getPlanterId()).get();
	}
	
}
