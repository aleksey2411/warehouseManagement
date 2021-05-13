package com.yakubovskiy.warehousemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	private String name;
	private int quantity;
	private int price;
	private String manufacturer;
	@ManyToOne
	private Customer customer;
	@ManyToOne
	private Supplier supplier;


	@Builder
	public Product(int id, String name, int quantity, int price, String manufacturer,
				   Customer customer, Supplier supplier) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.manufacturer = manufacturer;
		this.customer = customer;
		this.supplier = supplier;
	}
}
