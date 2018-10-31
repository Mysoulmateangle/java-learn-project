package com.zhou.dao.imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zhou.bean.user;
import com.zhou.dao.userdao;
import com.zhou.utils.DBUtils;

public class userdaoImp implements userdao{

	public user querylogin(user user) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConn();
		QueryRunner qr = new QueryRunner();
		String sql="select * from user where username =? and password=?";
		Object[] params= {user.getUsername(),user.getPassword()};
		user u =null;
		try {
			 u = qr.query(conn, sql, new BeanHandler<user>(user.class), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	public List<user> queryList() {
		Connection conn = DBUtils.getConn();
		QueryRunner qr = new QueryRunner();
		String sql="select * from user ";
		
		 List<user> list=null;
		try {
		 list = qr.query(conn, sql, new BeanListHandler<user>(user.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int add(user user) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConn();
		QueryRunner qr = new QueryRunner();
		String sql="insert into user values(null,?,?,?,?)";
		Object[] params= {user.getUsername(),user.getPassword(),user.getAge(),user.getSex()};
		try {
			int update = qr.update(conn, sql, params);
			return update;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
