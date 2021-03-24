package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cg.sprint1_onlineplantnursery.entity.Customer;
import com.cg.sprint1_onlineplantnursery.entity.User;
import com.cg.sprint1_onlineplantnursery.exception.UserNotFoundException;

@Service
public interface IUserService {
	
	
	    User register(User user);
	
	    User login(User user);

	    User resetPasswordById(Integer id, Map<Object, Object> fields) throws UserNotFoundException;
	    
	    
	    User resetEmailById(Integer id, Map<Object, Object> fields) throws UserNotFoundException;

}