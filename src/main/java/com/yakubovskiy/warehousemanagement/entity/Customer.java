package com.yakubovskiy.warehousemanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Table(name = "customers")
public class Customer extends Client{
	@OneToMany(mappedBy = "customer")
	@JsonIgnore
	private List<Product> products;

	@Builder
	public Customer(int id, String name, String account, String address, String phone,
					String UNP) {
		super(id, name, account, address, phone, UNP);
	}
}
