package com.yakubovskiy.warehousemanagement.repository;

import com.yakubovskiy.warehousemanagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {
	Optional<Product> findById(int id);
}
