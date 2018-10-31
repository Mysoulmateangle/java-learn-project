package com.zhou.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class test3 {
	//使用JDBC preparatedstatement 进行删除
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection("jdbc:mysql://127.0.1:3306/javaee1805?useUncide=true&characterEncoding=utf-8", "root", "123456");
			 String sql="delete from emp where empno=?";
			 ps = conn.prepareStatement(sql);
			 ps.setObject(1, 2121);
			 int point = ps.executeUpdate();
			 if (point==1) {
				System.out.println("修改成功");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	finally {
			
			try {//关闭连接
				
				if(ps!=null){
					ps.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
