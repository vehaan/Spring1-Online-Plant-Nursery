package com.cg.sprint1_onlineplantnursery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.sprint1_onlineplantnursery.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer>{
	Optional<Customer> findByEmail(String email);
    
    Optional<Customer> findById(Integer id);
}
