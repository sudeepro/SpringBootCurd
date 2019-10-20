package com.sudeep.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "proentity")
/**
 * 
 * @author SRI RegisterEntity
 */
public class RegisterEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1745578938005425808L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 15)
	private Integer userId;
	@Column(length = 15)
	private String name;
	@Column(length = 50)
	private String email;
	@Column(length = 15)
	private String pwd;
	@Column(length = 15)
	private Long phone;
	@Column(length = 15)
	private String country;

}
