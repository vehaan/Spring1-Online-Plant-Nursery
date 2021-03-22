package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;
import java.util.Map;
import com.cg.sprint1_onlineplantnursery.entity.Planter;

public interface IPlanterService {
	
	//BASIC CRUD
	Planter addPlanter(Planter planter);
	Planter updatePlanter(Planter planter);
	Planter deletePlanter(Planter planter);
	Planter viewPlanter(int planterId);
	List<Planter> viewAllPlanters();
	
	Planter partialUpdatePlanter(Map<Object, Object> fields, int id);
	List<Planter> viewPlanters(double minCost, double maxCost);
	Planter removePlanterStock(Planter planter, int quantity);
	Planter addPlanterStock(int id, int quantity);

	//SORTBY
	List<Planter> costLowToHigh();
	List<Planter> costHighToLow();

	//FILTER
	List<Planter> viewPlantersByColor(String color);
	List<Planter> viewPlantersByHeight(float height);
	List<Planter> viewPlantersByShape(String planterShape);
	List<Planter> viewPlantersByCapacity(int capacity);
	List<Planter> viewPlantersByDrainageHoles(int drainageHoles);
	List<Planter> deletePlanters();
	
	
	
	
	
	
}
