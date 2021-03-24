package com.cg.sprint1_onlineplantnursery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.sprint1_onlineplantnursery.entity.Order;
import com.cg.sprint1_onlineplantnursery.entity.Planter;

@Repository
public interface IOrderRepository  extends JpaRepository<Order, Integer> {
	

}
