package com.zhou.JDBCutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class baseDao {
	//操作数据库的工具类
	static Connection conn=null;
	static PreparedStatement ps=null;
    static ResultSet rs=null;
	private static void openConn() {//获取数据库连接
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection("jdbc:mysql://127.0.1:3306/javaee1805?useUncide=true&characterEncoding=utf-8", "root", "123456");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void closeConn() {//关闭连接
		try {
			if (rs!=null) {
				rs.close();
			}
			if (ps!=null) {
				ps.close();
			}
			if (conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static ResultSet query(String sql,Object[] parms) {
		try {//查询数据通过parms进行数据交互
			openConn();
			 ps = conn.prepareStatement(sql);
			 for (int i = 0; i < parms.length; i++) {
				ps.setObject(i+1, parms[i]);
			}
			  rs = ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//closeConn();在查询数据库的时候不要关闭数据库
		}
		return rs;
		
	}
	public static int update(String sql,Object[] parms) {
		try {//实现数据的修改，使用parms进行数据的交互
			openConn();
			 ps = conn.prepareStatement(sql);
			for (int i = 0; i < parms.length; i++) {
				ps.setObject(i+1, parms[i]);
			}
			int point = ps.executeUpdate();
			return point;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConn();
		return 0;
		
	}
}
