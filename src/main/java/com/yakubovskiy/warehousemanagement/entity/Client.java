package com.yakubovskiy.warehousemanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	private String name;
	private String account;
	private String unp;
	private String phone;
	private String address;

	public Client(int id, String name, String account, String address, String phone, String unp) {
		this.id = id;
		this.name = name;
		this.account = account;
		this.address = address;
		this.phone = phone;
		this.unp = unp;
	}
}
