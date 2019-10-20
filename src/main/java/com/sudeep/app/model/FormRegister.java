package com.sudeep.app.model;

import lombok.Data;

@Data
public class FormRegister {

	private Integer userId;
	private String name;
	private String pwd;
	private String email;
	private Long phone;
	private String country;

}
