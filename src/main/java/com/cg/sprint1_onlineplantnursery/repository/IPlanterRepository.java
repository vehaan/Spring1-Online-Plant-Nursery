package com.cg.sprint1_onlineplantnursery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.sprint1_onlineplantnursery.entity.Planter;

public interface IPlanterRepository extends JpaRepository<Planter, Integer>{
	
}
