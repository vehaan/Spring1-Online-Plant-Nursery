package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;
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
		return iplanterRepo.save(planter);
	}

	@Override
	public Planter deletePlanter(Planter planter) {
		Planter p = iplanterRepo.findById(planter.getPlanterId()).get();
		if (p != null)
			iplanterRepo.delete(p);
		return planter;
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
		List<Planter> requiredPlanters = iplanterRepo.findAll();
		for (Planter planter: requiredPlanters) {
			if (planter.getPlanterCost() < minCost || planter.getPlanterCost() > maxCost)
				requiredPlanters.remove(planter);
		}
		return requiredPlanters;
	}

	@Override
	public Planter viewPlanter(String planterShape) {
		List<Planter> requiredPlanters = iplanterRepo.findAll();
		for (Planter planter: requiredPlanters) {
			if (planter.getPlanterShape().equals(planterShape))
				return planter;
		}
		return null;
			
	}

	@Override
	public Planter updatePlanter(Planter planter) {
		return iplanterRepo.save(planter);
	}
	
}
