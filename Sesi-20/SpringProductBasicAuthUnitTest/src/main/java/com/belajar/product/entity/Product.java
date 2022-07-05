package com.belajar.product.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "tb_product")
@Data
@ToString
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "harga_beli")
	private int harga_beli;

	@Column(name = "harga_jual")
	private int harga_jual;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHargaBeli() {
		return harga_beli;
	}

	public void setHargaBeli(int harga_beli) {
		this.harga_beli = harga_beli;
	}

	public int getHargaJual() {
		return harga_jual;
	}

	public void setHargaJual(int harga_jual) {
		this.harga_jual = harga_jual;
	}

}