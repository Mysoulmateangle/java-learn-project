package com.zhou.dao.Imp;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.zhou.Utils.DBUtils;
import com.zhou.bean.user;
import com.zhou.dao.userDao;

public class userDaoImp implements userDao{
	
	@Override
	public int add(user u) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConn();
		String sql="insert into user values (null,?,?,?,?,?)";
		QueryRunner qr=new QueryRunner();
		Object[] params= {u.getUname(),u.getPassword(),u.getRealname(),u.getRid(),u.getRegtime()};
		try {
			return qr.update(conn, sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int query(user u) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConn();
		String sql="select * from user where uname=? and password=? and rid=2";
		QueryRunner qr = new QueryRunner();
		try {
			Object[] params= {u.getUname(),u.getPassword()};
			user user = qr.query(conn, sql, new BeanHandler<>(user.class),params);
			while (user!=null) {
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
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
		Connection conn = DBUtils.getConn();
		String sql="select * from user where uname=? and password=? and rid=1";
		QueryRunner qr = new QueryRunner();
		try {
			Object[] params= {u.getUname(),u.getPassword()};
			user user = qr.query(conn, sql, new BeanHandler<>(user.class), params);
			while (user!=null) {
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}

}
