package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;

import com.cg.sprint1_onlineplantnursery.entity.Planter;
import com.cg.sprint1_onlineplantnursery.repository.IPlanterRepository;
import com.cg.sprint1_onlineplantnursery.repository.IPlanterRepositoryImpl;

public class IPlanterServiceImpl implements IPlanterService {
	
	IPlanterRepository iplanterRepo = new IPlanterRepositoryImpl();
	
	@Override
	public Planter addPlanter(Planter planter) {
		return iplanterRepo.addPlanter(planter);
	}

	@Override
	public Planter updatePlanter(Planter planter) {
		return iplanterRepo.updatePlanter(planter);
	}

	@Override
	public Planter deletePlanter(Planter planter) {
		return iplanterRepo.deletePlanter(planter);
	}

	@Override
	public Planter viewPlanter(int planterId) {
		return iplanterRepo.viewPlanter(planterId);
	}

	@Override
	public Planter viewPlanter(String planterShape) {
		return iplanterRepo.viewPlanter(planterShape);
	}

	@Override
	public List<Planter> viewAllPlanters() {
		return iplanterRepo.viewAllPlanters();
	}

	@Override
	public List<Planter> viewAllPlanters(double minCost, double maxCost) {
		return iplanterRepo.viewAllPlanters(minCost, maxCost);
	}

}
