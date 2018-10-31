package com.zhou.bean;

public class user {
	private int id;
	private String uname;
	private String password;
	private String realname;
	private int rid;
	private String regtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public user(String uname, String password, int rid) {
		super();
		this.uname = uname;
		this.password = password;
		this.rid = rid;
	}
	
	public user() {
		super();
	}
	public user(String uname, String password) {
		super();
		this.uname = uname;
		this.password = password;
	}
	public user(String uname, String password, String realname, int rid, String regtime) {
		super();
		this.uname = uname;
		this.password = password;
		this.realname = realname;
		this.rid = rid;
		this.regtime = regtime;
	}
	

}
