package com.xa.potatoo.model.dto;

public class ProductDto {
	
	private Long productId;
	private String name;
	private String description;
	private double price;
	private double stock;
	private boolean active;
	
	private Long varnId;
	private String varnName;
	private Long cateId;
	private String cateName;
	
	
	public ProductDto(Long productId, String name, String description, double price, double stock, boolean active,
			Long varnId, String varnName, Long cateId, String cateName) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.active = active;
		this.varnId = varnId;
		this.varnName = varnName;
		this.cateId = cateId;
		this.cateName = cateName;
	}
	
	
	public ProductDto() {
		super();
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getStock() {
		return stock;
	}
	public void setStock(double stock) {
		this.stock = stock;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Long getVarnId() {
		return varnId;
	}
	public void setVarnId(Long varnId) {
		this.varnId = varnId;
	}
	public String getVarnName() {
		return varnName;
	}
	public void setVarnName(String varnName) {
		this.varnName = varnName;
	}
	public Long getCateId() {
		return cateId;
	}
	public void setCateId(Long cateId) {
		this.cateId = cateId;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	
	

}
