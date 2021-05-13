package com.yakubovskiy.warehousemanagement.service.impl;

import com.yakubovskiy.warehousemanagement.entity.Customer;
import com.yakubovskiy.warehousemanagement.repository.CustomerRepository;
import com.yakubovskiy.warehousemanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerServiceImpl implements CustomerService {
	private CustomerRepository customerRepository;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer findById(int id) {
		return customerRepository.findById(id)
				.orElseThrow(()-> new NoSuchElementException());
	}

	@Override
	public List<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public void removeCustomer(int id) {
		Customer customer = findById(id);
		customerRepository.delete(customer);
	}


}
