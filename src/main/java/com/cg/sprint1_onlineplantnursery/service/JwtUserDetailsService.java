package com.cg.sprint1_onlineplantnursery.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.sprint1_onlineplantnursery.entity.Admin;
import com.cg.sprint1_onlineplantnursery.entity.Customer;
import com.cg.sprint1_onlineplantnursery.entity.Role;
import com.cg.sprint1_onlineplantnursery.repository.IUserRepository;
@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserService service;
	@Autowired
	private IUserRepository repo;
	
	@Autowired
	private ICustomerService customerService;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		

     Optional<com.cg.sprint1_onlineplantnursery.entity.User> user =  repo.findByEmail(username);
	      
      com.cg.sprint1_onlineplantnursery.entity.User validuser= ((UserServiceImpl) service).findUser(user);
	      if(validuser==null)
	    	  throw new UsernameNotFoundException("user not found"+username);
	      
	      return  new org.springframework.security.core.userdetails.User(validuser.getEmail(), validuser.getPassword(), new ArrayList<>());
	      
	
	}

	public com.cg.sprint1_onlineplantnursery.entity.User save(com.cg.sprint1_onlineplantnursery.entity.Customer user) {
		
		System.out.println("In service Jwt");
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		
		return customerService.register(user);
			
		
	}

}