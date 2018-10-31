package com.zhou.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class test2 {
	//使用JDBC进行数据的新增
	public static void main(String[] args) {
		Connection conn=null;
		Statement stm=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//获取驱动
			conn=DriverManager.getConnection("jdbc:mysql://127.0.1:3306/javaee1805?useUncide=true&characterEncoding=utf-8", "root", "123456");
			 stm = conn.createStatement();
			 String sql = "insert into emp values(211,'dad','dada',321,'2015-8-29',200,100,20)";
			int point = stm.executeUpdate(sql);
			if (point==1) {
				System.out.println("添加成功");
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
