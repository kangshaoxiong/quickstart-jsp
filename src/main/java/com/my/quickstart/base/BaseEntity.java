package com.my.quickstart.base;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
/**
 * 基础实体类，提供公用的自增Id字段
 * @author Alan
 *
 */
@MappedSuperclass 
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = 2644706779236559973L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
