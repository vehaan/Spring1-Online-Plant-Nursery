package com.cg.sprint1_onlineplantnursery.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;
import com.cg.sprint1_onlineplantnursery.entity.Admin;
import com.cg.sprint1_onlineplantnursery.entity.Customer;
import com.cg.sprint1_onlineplantnursery.entity.Order;
import com.cg.sprint1_onlineplantnursery.entity.Role;
import com.cg.sprint1_onlineplantnursery.entity.User;
import com.cg.sprint1_onlineplantnursery.exception.UserNotFoundException;
import com.cg.sprint1_onlineplantnursery.repository.IUserRepository;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	// method to register or add the user

	@Override
	public User register(User user) {

		User userToBeCreated = null;

		if (user instanceof Customer) {

			if (userRepository.findByEmail(user.getEmail()).isPresent())
				throw new UserNotFoundException("Email is already registered.Try to login");
			else if (user.getRole() == Role.ADMIN)
				throw new UserNotFoundException("Customer role cannot be admin");
			
			userToBeCreated = userRepository.save(user);

		}

		else if (user instanceof Admin) {
			if (userRepository.findByEmail(user.getEmail()).isPresent())
				throw new UserNotFoundException("Email is already registered.Try to login");

			// TODO implement only admin can add another admin

			userToBeCreated = userRepository.save(user);

		}

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
	public User resetPasswordById(Integer id, Map<Object, Object> fields) throws UserNotFoundException {
		if (userRepository.findById(id).isEmpty())
			throw new UserNotFoundException("Not customer found by id : " + id);
		else {

			User user = userRepository.findById(id).get();

			fields.forEach((k, v) -> {
				Field field = ReflectionUtils.findRequiredField(User.class, (String) k);

				field.setAccessible(true);

				try {
					if (field.getName().equals("email")) {
						if (!field.get(user).toString().equals(v.toString()))
							throw new UserNotFoundException("Email mismatch for the id :" + id);

					}
				} catch (IllegalArgumentException | IllegalAccessException e) {

				}
				ReflectionUtils.setField(field, user, v);
			});

			return userRepository.save(user);
		}
	}

	// method to reset the userEmail using the userId
	@Override
	public User resetEmailById(Integer id, Map<Object, Object> fields) throws UserNotFoundException {

		if (userRepository.findById(id).isEmpty())
			throw new UserNotFoundException("Not customer found by id : " + id);
		else {
			User user = userRepository.findById(id).get();

			fields.forEach((k, v) -> {
				Field field = ReflectionUtils.findRequiredField(User.class, (String) k);

				field.setAccessible(true);

				if (field.getName().equals("email")) {
					if (userRepository.findByEmail(v.toString()).isPresent())
						throw new UserNotFoundException("Email is already register .Try to login");

				}

				ReflectionUtils.setField(field, user, v);
			});

			return userRepository.save(user);
		}

	}

}