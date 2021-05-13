package com.yakubovskiy.warehousemanagement.service.impl;

import com.yakubovskiy.warehousemanagement.entity.Role;
import com.yakubovskiy.warehousemanagement.entity.User;
import com.yakubovskiy.warehousemanagement.repository.RoleRepository;
import com.yakubovskiy.warehousemanagement.repository.UserRepository;
import com.yakubovskiy.warehousemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	public List<User> findAllUsers() {
		return userRepository.findByActive(true);
	}

	public User save(User user) {
	user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(true);
		Role role = roleRepository.findByRole("ROLE_USER");
		user.setRoles(new HashSet<>(List.of(role)));
		return userRepository.save(user);
	}

	@Override
	public void removeUser(int id) {
		User user = findUserById(id);
		userRepository.delete(user);
	}

	@Override
	public User findUserByUsername(String username) {
		return userRepository.findUserByUsername(username)
				.orElseThrow(() -> new NoSuchElementException());
	}

	@Override
	public User findUserById(int id) {
		return userRepository.findUserById(id)
				.orElseThrow(()->new NoSuchElementException());
	}
}
