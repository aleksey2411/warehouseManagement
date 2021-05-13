package com.yakubovskiy.warehousemanagement.service.impl;

import com.yakubovskiy.warehousemanagement.entity.Supplier;
import com.yakubovskiy.warehousemanagement.repository.SupplierRepository;
import com.yakubovskiy.warehousemanagement.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SupplierServiceImpl implements SupplierService {
	private SupplierRepository supplierRepository;

	@Autowired
	public SupplierServiceImpl(SupplierRepository supplierRepository) {
		this.supplierRepository = supplierRepository;
	}

	@Override
	public Supplier save(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	@Override
	public Supplier findById(int id) {
		return supplierRepository.findById(id)
				.orElseThrow(()->new NoSuchElementException());
	}

	@Override
	public List<Supplier> findAllSuppliers() {
		return supplierRepository.findAll();
	}

	@Override
	public void removeSupplier(int id) {
		Supplier supplier = findById(id);
		supplierRepository.delete(supplier);
	}
}
