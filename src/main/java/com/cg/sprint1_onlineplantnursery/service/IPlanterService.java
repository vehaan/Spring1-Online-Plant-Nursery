package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.sprint1_onlineplantnursery.entity.Planter;

public interface IPlanterService {
	Planter addPlanter(Planter planter);

	Planter updatePlanter(Planter planter);

	Planter deletePlanter(Planter planter);

	Planter viewPlanter(int planterId);

	List<Planter> viewPlanter(String planterShape);

	List<Planter> viewAllPlanters();

	List<Planter> viewAllPlanters(double minCost, double maxCost);
}
