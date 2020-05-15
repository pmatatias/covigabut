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
import javax.validation.constraints.NotBlank;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.xa.potatoo.abstaction.SuperUser;

@Entity
@Table(name = "variant")

public class Variant extends SuperUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	@NotBlank(message = "varian harus diisi")
	private String name;
	
	@Column (name = "description", nullable = true)
	private String description;
	
	@Column (name = "is_active")
	private boolean isActive;
	
	@ManyToOne(fetch =FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name = "category")
	private Category category;
	
	
	

	public Variant() {
		super();
	}
	
	public Variant(@NotBlank(message = "varian harus diisi") String name, String description, boolean isActive,
			Category category) {
		super();
		this.name = name;
		this.description = description;
		this.isActive = isActive;
		this.category = category;
	}


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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategoryId(Category category) {
		this.category = category;
	}
	
	

}
