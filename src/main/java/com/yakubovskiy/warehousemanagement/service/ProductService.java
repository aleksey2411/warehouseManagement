package com.yakubovskiy.warehousemanagement.service;

import com.yakubovskiy.warehousemanagement.dto.ProductDTO;
import com.yakubovskiy.warehousemanagement.entity.Product;

import java.util.List;

public interface ProductService {
	Product save(ProductDTO productDTO);

	Product findById(int id);

	List<Product> findAllProducts();

	void sellProduct(int productId, int quantity);

	void removeProduct(int productId);
}
