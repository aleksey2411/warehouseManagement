package com.yakubovskiy.warehousemanagement.controller;

import com.yakubovskiy.warehousemanagement.entity.Customer;
import com.yakubovskiy.warehousemanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {
	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/add-customer")
	public String addCustomer(Model model) {
		model.addAttribute(new Customer());
		return "add-customer";
	}

	@PostMapping("/add-customer")
	public String addCustomer(@ModelAttribute Customer customer) {
		customerService.save(customer);
		return "redirect:customers";
	}

	@GetMapping("/customers")
	public String findAllCustomers(Model model) {
		List<Customer> customers = customerService.findAllCustomers();
		model.addAttribute("customers", customers);
		return "customers";
	}

	@GetMapping("/customer/{id}")
	public String findCustomer(@PathVariable(value = "id") int id, Model model) {
		Customer customer = customerService.findById(id);
		List<Customer> customers = new ArrayList<>();
		customers.add(customer);
		model.addAttribute("customer", customers);
		return "customer-details";
	}

	@PostMapping("/customer/{id}/remove")
	public String removeCustomer(@PathVariable(value = "id") int id, Model model) {
		customerService.removeCustomer(id);
		return "customers";
	}

}
