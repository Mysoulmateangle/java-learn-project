package com.zhou.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class test4 {
	//使用JDBC进行数据修改
	public static void main(String[] args) {
		Connection conn=null;
		Statement stm=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection("jdbc:mysql://127.0.1/javaee1805?useUncide=true&characterEncoding=utf-8", "root", "123456");
			  stm = conn.createStatement();
			  String sql = "update emp set sal=80000 where empno=7369";
			int point = stm.executeUpdate(sql);
			if (point==1) {
				System.out.println("修改成功");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {//关闭连接
				
				if(stm!=null){
					stm.close();
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
