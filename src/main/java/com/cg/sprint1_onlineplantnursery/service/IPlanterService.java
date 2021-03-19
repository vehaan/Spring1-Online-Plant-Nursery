package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;

import com.cg.sprint1_onlineplantnursery.entity.Planter;
import com.cg.sprint1_onlineplantnursery.exception.ResourceNotFoundException;

public interface IPlanterService {
	Planter addPlanter(Planter planter);

	Planter updatePlanter(Planter planter) throws ResourceNotFoundException;

	Planter deletePlanter(Planter planter) throws ResourceNotFoundException;

	Planter viewPlanter(int planterId) throws ResourceNotFoundException;

	List<Planter> viewPlantersByShape(String planterShape);

	List<Planter> viewAllPlanters();

	List<Planter> viewAllPlanters(double minCost, double maxCost);

	Planter deleteEntireStock(int id) throws ResourceNotFoundException;
}
