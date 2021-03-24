package com.cg.sprint1_onlineplantnursery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.sprint1_onlineplantnursery.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByEmail(String userName);



	
}
