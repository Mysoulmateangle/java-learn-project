package com.zhou.service.imp;

import java.util.List;

import com.zhou.bean.user;

import com.zhou.dao.imp.userdaoImp;
import com.zhou.service.userservice;

public class userserviceimp implements userservice {
		userdaoImp userdaoImp=new userdaoImp();
	public user querylogin(user user) {
		// TODO Auto-generated method stub
		return userdaoImp.querylogin(user);
	}
	public List<user> queryList() {
		// TODO Auto-generated method stub
		return userdaoImp.queryList();
	}
	public int add(user user) {
		// TODO Auto-generated method stub
		return userdaoImp.add(user);
	}

}
