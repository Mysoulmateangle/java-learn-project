package com.zhou.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class test2 {
	//使用JDBC prepareStatment 进行新增数据
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection("jdbc:mysql://127.0.1:3306/javaee1805?useUncide=true&characterEncoding=utf-8", "root", "123456");
			 String sql="insert into emp values(?,?,?,?,?,?,?,?)";
			 ps = conn.prepareStatement(sql);
			 ps.setObject(1, 2121);
			 ps.setObject(2, "dadad");
			 ps.setObject(3,"sdad");
			 ps.setObject(4, 231312);
			 ps.setObject(5, "1998-8-29");
			 ps.setObject(6, 3231);
			 ps.setObject(7, 313);
			 ps.setObject(8, 12);
			 int point = ps.executeUpdate();
			 if (point==1) {
				System.out.println("新增成功");
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
