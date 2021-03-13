package com.cg.sprint1_onlineplantnursery.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.sprint1_onlineplantnursery.entity.Planter;

@Repository
public interface IPlanterRepository extends JpaRepository<Planter, Integer> {

}
