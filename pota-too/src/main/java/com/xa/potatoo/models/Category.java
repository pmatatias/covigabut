package com.xa.potatoo.models;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.xa.potatoo.abstaction.SuperUser;

@Entity
@Table(name = "category")
public class Category extends SuperUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name",nullable = false)
	private String name;
	
	@Column(name = "description",nullable = true)
	private String description;
	
	@OneToMany (mappedBy = "category", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonBackReference
	private Set<Variant> variants;
	
	

	public Category() {
		super();
	}

	public Category(String name, String description, Set<Variant> variants) {
		super();
		this.name = name;
		this.description = description;
		this.variants = variants;
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

	public Set<Variant> getVariants() {
		return variants;
	}

	public void setVariants(Set<Variant> variants) {
		this.variants = variants;
	}
}
