package com.zhou.bean;

public class user {
	private String username;
	private String password;
	private int id;
	private int age;
	private String sex;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public user(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public user(String username, String password, int age, String sex) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.sex = sex;
	}

	public user() {
		super();
	}
	
	public user(String username, String password, int id, int age, String sex) {
		super();
		this.username = username;
		this.password = password;
		this.id = id;
		this.age = age;
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "user [username=" + username + ", password=" + password + "]";
	}

}
