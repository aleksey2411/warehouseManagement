package com.yakubovskiy.warehousemanagement.dto;

import com.yakubovskiy.warehousemanagement.entity.Customer;
import com.yakubovskiy.warehousemanagement.entity.Supplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProductDTO {
	private int id;
	private String name;
	private int quantity;
	private int price;
	private String manufacturer;
	private String customerId;
	private String supplierId;
}
