package com.hcl.productanalytics.api.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="user_detail")
@Data
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private String password;
	private String phoneNumber;

}
