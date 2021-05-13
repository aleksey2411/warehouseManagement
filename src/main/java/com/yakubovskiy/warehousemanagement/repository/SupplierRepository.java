package com.yakubovskiy.warehousemanagement.repository;

import com.yakubovskiy.warehousemanagement.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, String> {
	Optional<Supplier> findById(int id);
}
