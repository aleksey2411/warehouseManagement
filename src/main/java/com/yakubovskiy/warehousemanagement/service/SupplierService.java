package com.yakubovskiy.warehousemanagement.service;

import com.yakubovskiy.warehousemanagement.entity.Supplier;

import java.util.List;

public interface SupplierService {
	Supplier save(Supplier supplier);
	Supplier findById(int id);
	List<Supplier> findAllSuppliers();
	void removeSupplier(int id);
}
