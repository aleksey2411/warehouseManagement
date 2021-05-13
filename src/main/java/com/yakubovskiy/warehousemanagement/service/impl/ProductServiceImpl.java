package com.yakubovskiy.warehousemanagement.service.impl;

import com.yakubovskiy.warehousemanagement.dto.ProductDTO;
import com.yakubovskiy.warehousemanagement.entity.Product;
import com.yakubovskiy.warehousemanagement.repository.ProductRepository;
import com.yakubovskiy.warehousemanagement.service.ProductService;
import com.yakubovskiy.warehousemanagement.service.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {
	private ProductRepository productRepository;
	private ProductMapper productMapper;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
		this.productRepository = productRepository;
		this.productMapper = productMapper;
	}

	@Override
	public Product save(ProductDTO productDTO) {
		Product product = productMapper.toEntitySup(productDTO);
		return productRepository.save(product);
	}

	@Override
	public Product findById(int id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException());
	}

	@Override
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public void sellProduct(int productId, int quantity) {
		Product product = findById(productId);
		System.out.println(product.getQuantity());
		System.out.println(quantity);
		if (product.getQuantity() == quantity) {
			productRepository.delete(product);
		}
		if (product.getQuantity() > quantity) {
			product.setQuantity(product.getQuantity() - quantity);
			productRepository.saveAndFlush(product);
		} else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public void removeProduct(int productId) {
		Product product = findById(productId);
		productRepository.delete(product);
	}
}
