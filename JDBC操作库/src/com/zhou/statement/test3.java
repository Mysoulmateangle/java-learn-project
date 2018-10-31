package com.zhou.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class test3 {
	//用JDBC进行数据的删除
	public static void main(String[] args) {
		Connection conn=null;
		Statement stm=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//获取驱动
			conn=DriverManager.getConnection("jdbc:mysql://127.0.1:3306/javaee1805?useUncide=true&characterEncoding=utf-8", "root", "123456");
			//建立连接
			 stm = conn.createStatement();//获取操作数据库对象
			 String sql="delete from emp where empno=211";
			int point = stm.executeUpdate(sql);
			if (point==1) {
				System.out.println("删除成功");
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
