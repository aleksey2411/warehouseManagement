package com.yakubovskiy.warehousemanagement.service;

import com.yakubovskiy.warehousemanagement.entity.Customer;

import java.util.List;

public interface CustomerService {
	Customer save(Customer customer);
	Customer findById(int id);
	List<Customer> findAllCustomers();
	void removeCustomer(int id);
}
