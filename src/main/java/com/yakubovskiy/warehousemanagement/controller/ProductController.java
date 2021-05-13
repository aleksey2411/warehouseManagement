package com.yakubovskiy.warehousemanagement.controller;

import com.yakubovskiy.warehousemanagement.dto.ProductDTO;
import com.yakubovskiy.warehousemanagement.entity.Customer;
import com.yakubovskiy.warehousemanagement.entity.Product;
import com.yakubovskiy.warehousemanagement.entity.Supplier;
import com.yakubovskiy.warehousemanagement.service.CustomerService;
import com.yakubovskiy.warehousemanagement.service.ProductService;
import com.yakubovskiy.warehousemanagement.service.SupplierService;
import com.yakubovskiy.warehousemanagement.service.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
	private ProductService productService;
	private SupplierService supplierService;
	private CustomerService customerService;
	private ProductMapper productMapper;

	@Autowired
	public ProductController(ProductService productService, SupplierService supplierService, CustomerService customerService, ProductMapper productMapper) {
		this.productService = productService;
		this.supplierService = supplierService;
		this.customerService = customerService;
		this.productMapper = productMapper;
	}

	@GetMapping("/add-product")
	public String addProduct(Model model) {
		List<Supplier> suppliers = supplierService.findAllSuppliers();
		model.addAttribute("suppliers", suppliers);
		model.addAttribute(new ProductDTO());
		return "add-product";
	}

	@PostMapping("/add-product")
	public String addProduct(@ModelAttribute ProductDTO productDTO) {
		productService.save(productDTO);
		return "add-product";
	}

	@GetMapping("/sell-product")
	public String sellProduct(Model model) {
		List<Customer> customers = customerService.findAllCustomers();
		model.addAttribute("customers", customers);
		List<Product> products = productService.findAllProducts();
		model.addAttribute("products", products);
		return "sell-product";
	}

	@PostMapping("/sell-product/{id}")
	public String sellProduct(@PathVariable(value = "id") int id, @RequestParam int quantity) {
		productService.sellProduct(id, quantity);
		return "sell-product";
	}

	@GetMapping("/products")
	public String findAllProducts(Model model) {
		List<Product> products = productService.findAllProducts();
		model.addAttribute("products", products);
		return "products";
	}

	@GetMapping()
	public String home() {
		return "redirect:products";
	}

	@GetMapping("/product/{id}")
	public String findProduct(@PathVariable(value = "id") int id, Model model) {
		Product product = productService.findById(id);
		List<Product> products = new ArrayList<>();
		products.add(product);
		model.addAttribute("product", products);
		return "product-details";
	}

	@PostMapping("/product/{id}/remove")
	public String removeProduct(@PathVariable(value = "id") int id, Model model) {
		productService.removeProduct(id);
		return "products";
	}

}
