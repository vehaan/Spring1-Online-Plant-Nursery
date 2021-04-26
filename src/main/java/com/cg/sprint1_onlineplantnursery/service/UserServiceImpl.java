package com.cg.sprint1_onlineplantnursery.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.cg.sprint1_onlineplantnursery.entity.Admin;
import com.cg.sprint1_onlineplantnursery.entity.Customer;
import com.cg.sprint1_onlineplantnursery.entity.Role;
import com.cg.sprint1_onlineplantnursery.entity.Status;
import com.cg.sprint1_onlineplantnursery.entity.User;
import com.cg.sprint1_onlineplantnursery.exception.ResourceNotFoundException;
import com.cg.sprint1_onlineplantnursery.exception.UserAlreadyExists;
import com.cg.sprint1_onlineplantnursery.exception.UserNotFoundException;
import com.cg.sprint1_onlineplantnursery.repository.IUserRepository;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	// method to register or add the user

	@Override
	public User register(User user) {

		User userToBeCreated = null;

		if (user instanceof Customer) {
			
			System.out.println("In userImplService  Customer");

			if (userRepository.findByEmail(user.getEmail()).isPresent())
				throw new UserAlreadyExists("Email is already registered.Try to login");
			

			userToBeCreated = userRepository.save(user);

		}

		else if (user instanceof Admin){
			
			System.out.println("In userImplService  Admin");
			if (userRepository.findByEmail(user.getEmail()).isPresent())
				throw new UserAlreadyExists("Email is already registered.Try to login");
			user.setPassword(bcryptEncoder.encode(user.getPassword()));
			userToBeCreated = userRepository.save(user);

		}
		
		System.out.println("In userImplService  outside the instance");

		return userToBeCreated;

	}

	// method for the authentication of the user

	@Override
	public User login(User user) {
		String userName = user.getEmail();
		String password = user.getPassword();

		Optional<User> optionalUser = userRepository.findByEmail(userName);

		if (optionalUser.isEmpty() || !optionalUser.get().getPassword().equals(password)) {

			throw new UserNotFoundException("Bad Credentials");
		}

		return optionalUser.get();
	}

	// method to reset the password using userId and userEmail

	@Override
	public User resetPasswordById(User user) throws UserNotFoundException {
		if (userRepository.findByEmail(user.getEmail()).isEmpty())
			throw new UserNotFoundException("Not customer found by email : " + user.getEmail());
		/*
		 * else {
		 * 
		 * User user = userRepository.findById(id).get();
		 * 
		 * fields.forEach((k, v) -> { Field field =
		 * ReflectionUtils.findRequiredField(User.class, (String) k);
		 * 
		 * field.setAccessible(true);
		 * 
		 * try { if (field.getName().equals("email")) { if
		 * (!field.get(user).toString().equals(v.toString())) throw new
		 * UserNotFoundException("Email mismatch for the id :" + id);
		 * 
		 * } } catch (IllegalArgumentException | IllegalAccessException e) {
		 * 
		 * } ReflectionUtils.setField(field, user, v); });
		 */

		Optional<User> findByEmail = userRepository.findByEmail(user.getEmail());
		
		findByEmail.get().setPassword(bcryptEncoder.encode(user.getPassword()));
		
		
		
		
			return userRepository.save(findByEmail.get());
		
	}
	
	//method to get the users by role

	@Override
	public List<User> userByRole(Role role) {

		List<User> findAll = userRepository.findAll();
		List<User> collect = null;

		if (!findAll.isEmpty())
			collect = findAll.stream().filter(u -> u.getRole().equals(role)).collect(Collectors.toList());
		else
			throw new ResourceNotFoundException("Not records found for the role:" + role);

		return collect;
	}
	
	//method to delete the user using id

	@Override
	public User removeUser(Integer id) {
		
		
		Optional<User> findById = userRepository.findById(id);
		findById.orElseThrow(() -> new UserNotFoundException("There are no customer having id:" + id));

		userRepository.deleteById(id);

		return findById.get();
	}

	//method to update the user
	@Override
	public User updateUser(Integer id, User user) throws UserNotFoundException {
		Optional<User> findById = userRepository.findById(id);
		findById.orElseThrow(() -> new UserNotFoundException("There are no customer having id: " + id));

		if (userRepository.findByEmail(user.getEmail()).isPresent()) {
			if (userRepository.findByEmail(user.getEmail()).get().getId() != id)
				throw new UserAlreadyExists("Email is already registered try to login");

		}
		if(user instanceof Customer) {
			user.setRole(Role.CUSTOMER);
			((Customer) user).setStatus(Status.UNBLOCK);
		}
		
	
		user.setPassword(bcryptEncoder.encode(user.getPassword()));

		return userRepository.save(user);
	}

	public User findUser(Optional<User> user) {
		Optional<User> dbUser =  userRepository.findByEmail(user.get().getEmail());
    	System.out.println("db user " +dbUser);
    	if(dbUser==null)
    		throw new RuntimeException("user does nt exist");
    	if(!dbUser.get().getPassword().contentEquals(user.get().getPassword())) {
    		throw new RuntimeException("password mismatch");}
    	System.out.println("returning dbuser");
    	return dbUser.get();
	}
	
	
	
	@Override
	public User getUser(String email) {
		Optional<User> findByEmail = userRepository.findByEmail(email);

		
		
	System.out.println("I am in controller");
	    System.out.println(findByEmail.get());
     	System.out.println(email);
		return findByEmail.orElseThrow(() -> new UserNotFoundException("There are no customer having id:" + findByEmail));
		
		
		
	}

	

}