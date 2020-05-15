package com.xa.potatoo.abstaction;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

@MappedSuperclass 
public class SuperUser {
	@Column (name = "create_on", nullable = true)
	protected LocalDateTime createOn;
	
	@Column(name = "crate_by", nullable = true)
	protected String createBy;
	
	@Column (name = "modified_on", nullable = true)
	protected LocalDateTime modifiedOn;
	
	@Column (name = "modified_by", nullable = true)
	protected String modifiedBy;
	
	@Column (name = "is_delete",nullable = true)
	protected boolean isDelete= false;
	
	@PrePersist
	void createOn() {
		this.createBy = "potatoo";
		this.createOn = LocalDateTime.now();
	}
	

}
