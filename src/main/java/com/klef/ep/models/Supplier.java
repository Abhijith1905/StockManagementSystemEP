package com.klef.ep.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplier_table")
public class Supplier implements Serializable
{
	@Id
	private int id = (int) (Math.random()*9999)+1;
	@Column(name = "supplier_name",nullable = false,unique=true, length = 50)
	private String name;
	@Column(name = "supplier_age",nullable = false,precision = 4,scale = 2)
	private double age;
	@Column(name = "supplier_gender",nullable = false,length = 10)
	private String gender;
	@Column(name = "supplier_category",nullable=false,length = 50)
	private String category;
	@Column(name = "supplier_contact",nullable = false,length = 20,unique = true)
	private String contactno;
	@Column(name="supplier_email",nullable=false,length=50,unique=true)
	private String email;
	@Column(name = "supplier_pwd",nullable=false,length=20)
	private String password;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
