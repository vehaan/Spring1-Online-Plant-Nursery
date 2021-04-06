package com.cg.sprint1_onlineplantnursery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.sprint1_onlineplantnursery.entity.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

}
