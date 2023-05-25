package com.travishankarmishra.model;

public class User {

	private int sno;
	private String name;
	private String email;
	private String password;
	private String mobile;
	private String image;
	public User(int sno, String name, String email, String password, String mobile, String image) {
		super();
		this.sno = sno;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.image = image;
	}
	public User() {
		super();
	}
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
