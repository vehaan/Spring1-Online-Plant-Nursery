package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.cg.sprint1_onlineplantnursery.entity.Role;
import com.cg.sprint1_onlineplantnursery.entity.User;
import com.cg.sprint1_onlineplantnursery.exception.UserNotFoundException;

@Service
public interface IUserService {
	
	
	    User register(User user);
	
	    User login(User user);
	    
	    User updateUser(Integer id,User customer) throws UserNotFoundException;	
	    
	    User resetPasswordById(Integer id, Map<Object, Object> fields) throws UserNotFoundException;
	    
	    List<User> userByRole(Role role);
	    
	    User removeUser(Integer id);

}