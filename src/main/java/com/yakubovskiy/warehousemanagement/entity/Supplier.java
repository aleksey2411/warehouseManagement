package com.yakubovskiy.warehousemanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "suppliers")
public class Supplier extends Client{
	@OneToMany(mappedBy = "supplier")
	@JsonIgnore
	private List<Product> products;

	@Builder
	public Supplier(int id, String name, String account, String address, String phone,
					String UNP) {
		super(id, name, account, address, phone, UNP);
	}
}
