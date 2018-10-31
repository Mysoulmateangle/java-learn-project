package com.zhou.service;

import java.util.List;

import com.zhou.bean.user;

public interface userservice {
	public user querylogin(user user) ;
	public List<user> queryList() ;
	public int add(user user) ;
}
