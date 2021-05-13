package com.yakubovskiy.warehousemanagement.controller;

import com.yakubovskiy.warehousemanagement.entity.User;
import com.yakubovskiy.warehousemanagement.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
	private UserServiceImpl userService;

	@Autowired
	public UserController(UserServiceImpl userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public String findAllUsers(Model model) {
		List<User> users = userService.findAllUsers();
		users.forEach(System.out::println);
		model.addAttribute("users", users);
		return "users";
	}

	@GetMapping("/user/{id}")
	public String findUser(@PathVariable(value = "id") int id, Model model) {
		User user = userService.findUserById(id);
		List<User> users = new ArrayList<>();
		users.add(user);
		model.addAttribute("user", users);
		return "user-details";
	}

	@PostMapping("/user/{id}/remove")
	public String removeUser(@PathVariable(value = "id") int id, Model model) {
		userService.removeUser(id);
		return "users";
	}
}
