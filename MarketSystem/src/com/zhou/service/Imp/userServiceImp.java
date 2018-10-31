package com.zhou.service.Imp;

import com.zhou.bean.user;
import com.zhou.dao.Imp.userDaoImp;
import com.zhou.service.userService;

public class userServiceImp implements userService{
	userDaoImp us=new userDaoImp();
	@Override
	public int add(user u) {
		// TODO Auto-generated method stub
	 return	us.add(u);
	}

	@Override
	public int query(user u) {
		// TODO Auto-generated method stub
		return us.query(u);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int queryad(user u) {
		// TODO Auto-generated method stub
		return us.queryad(u);
		
	}

}
