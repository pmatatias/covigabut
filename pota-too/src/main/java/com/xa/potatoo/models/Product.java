package com.xa.potatoo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xa.potatoo.abstaction.SuperUser;

@Entity
@Table(name = "Product")

public class Product extends SuperUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long productId;
	
	@Column(name = "name",nullable = false)
	@Size(min = 2,max = 50)
	private String name;
	
	@Column(name = "description",nullable = true)
	private String description;
	
	@Column(name = "stock")
	private double stock;
	
	@Column(name = "price")
	@Digits(integer = 8, fraction = 2)
	private double price;
	
	@Column (name = "active")
	private boolean active;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name = "pro_var_id", nullable = true)
	private Variant variant;

	public Product() {
		super();
	}

	public Product(Long productId, @Size(min = 2, max = 50) String name, String description,
			@Size(min = 1, max = 10) double stock, @Digits(integer = 8, fraction = 2) double price, boolean active,
			Variant variant) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.stock = stock;
		this.price = price;
		this.active = active;
		this.variant = variant;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Variant getVariant() {
		return variant;
	}

	public void setVariant(Variant variant) {
		this.variant = variant;
	}
	
	
}
