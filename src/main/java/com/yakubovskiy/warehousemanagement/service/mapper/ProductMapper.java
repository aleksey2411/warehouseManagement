package com.yakubovskiy.warehousemanagement.service.mapper;

import com.yakubovskiy.warehousemanagement.dto.ProductDTO;
import com.yakubovskiy.warehousemanagement.entity.Product;
import com.yakubovskiy.warehousemanagement.entity.Supplier;
import com.yakubovskiy.warehousemanagement.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
	private SupplierService supplierService;

	@Autowired
	public ProductMapper(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

	public ProductDTO toDto(Product product) {
		return ProductDTO.builder()
				.id(product.getId())
				.name(product.getName())
				.manufacturer(product.getManufacturer())
				.price(product.getPrice())
				.quantity(product.getQuantity())
				.build();
	}

	public Product toEntitySup(ProductDTO productDTO) {
		Supplier supplier = supplierService.findById(Integer.valueOf(productDTO.getSupplierId()));
		return Product.builder()
				.id(productDTO.getId())
				.name(productDTO.getName())
				.price(productDTO.getPrice())
				.manufacturer(productDTO.getManufacturer())
				.quantity(productDTO.getQuantity())
				.supplier(supplier)
				.build();
	}
}
