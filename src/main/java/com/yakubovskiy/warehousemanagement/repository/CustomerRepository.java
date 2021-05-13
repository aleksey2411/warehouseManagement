package com.yakubovskiy.warehousemanagement.repository;

import com.yakubovskiy.warehousemanagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {
	Optional<Customer> findById(int id);
}
