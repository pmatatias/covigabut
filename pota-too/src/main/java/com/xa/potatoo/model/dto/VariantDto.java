package com.xa.potatoo.model.dto;

public class VariantDto {
	private Long varId;
	private String name;
	private String desc;
	private boolean active;
	private Long cateId;
	private String cateName;
	
	
	
	public VariantDto() {
		super();
	}
	public VariantDto(Long varId, String name, String desc, boolean active, Long cateId, String cateName) {
		super();
		this.varId = varId;
		this.name = name;
		this.desc = desc;
		this.active = active;
		this.cateId = cateId;
		this.cateName = cateName;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
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
