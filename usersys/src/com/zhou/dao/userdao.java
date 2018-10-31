package com.zhou.dao;

import java.util.List;

import com.zhou.bean.user;

public interface userdao {
	public user querylogin(user user) ;
	public List<user> queryList() ;
	public int add(user user) ;
}
