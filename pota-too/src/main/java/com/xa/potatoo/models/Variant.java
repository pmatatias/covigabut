package com.xa.potatoo.models;

import javax.persistence.CascadeType;
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
	private Long varId;
	
	@Column(name = "name")
	@NotBlank(message = "varian harus diisi")
	private String name;
	
	@Column (name = "description", nullable = true)
	private String description;
	
	@Column (name = "is_active")
	private boolean active;
	
	@ManyToOne(fetch =FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinColumn(name = "varn_cate_id")
	private Category category;
	

	public Variant() {
		super();
	}
	
	


	public Variant(Long varId, @NotBlank(message = "varian harus diisi") String name, String description, boolean active,
			Category category) {
		super();
		this.varId = varId;
		this.name = name;
		this.description = description;
		this.active = active;
		this.category = category;
	}




	public Long getVarId() {
		return varId;
	}

	public void setVarId(Long varId) {
		this.varId = varId;
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

	public boolean active() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategoryId(Category category) {
		this.category = category;
	}
	
	

}
