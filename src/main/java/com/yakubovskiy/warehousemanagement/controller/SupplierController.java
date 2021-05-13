package com.yakubovskiy.warehousemanagement.controller;

import com.yakubovskiy.warehousemanagement.entity.Supplier;
import com.yakubovskiy.warehousemanagement.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SupplierController {
	private SupplierService supplierService;

	@Autowired
	public SupplierController(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

	@GetMapping("/add-supplier")
	public String addSupplier(Model model) {
		model.addAttribute(new Supplier());
		return "add-supplier";
	}

	@PostMapping("/add-supplier")
	public String addSupplier(@ModelAttribute Supplier supplier) {
		supplierService.save(supplier);
		return "redirect:suppliers";
	}

	@GetMapping("/suppliers")
	public String findAllSuppliers(Model model) {
		List<Supplier> suppliers = supplierService.findAllSuppliers();
		model.addAttribute("suppliers",suppliers);
		return "suppliers";
	}

	@GetMapping("/supplier/{id}")
	public String findSupplier(@PathVariable(value = "id") int id, Model model) {
		Supplier supplier = supplierService.findById(id);
		List<Supplier> suppliers = new ArrayList<>();
		suppliers.add(supplier);
		model.addAttribute("supplier", suppliers);
		return "supplier-details";
	}

	@PostMapping("/supplier/{id}/remove")
	public String removeSupplier(@PathVariable(value = "id") int id, Model model) {
		supplierService.removeSupplier(id);
		return "suppliers";
	}

}
