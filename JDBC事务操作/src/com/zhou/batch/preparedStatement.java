package com.zhou.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class preparedStatement {
	//使用preparedStatement 进行批处理操作
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
		
			
			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection("jdbc:mysql://127.0.1:3306/javaee1805?useUncide=true&characterEncoding=utf-8", "root", "123456");
			String sql="insert into emp values(?,?,?,?,?,?,?,?)";
			 ps = conn.prepareStatement(sql);
			 conn.setAutoCommit(false);
			 ps.setObject(1, 2121);
			 ps.setObject(2, "dadad");
			 ps.setObject(3,"sdad");
			 ps.setObject(4, 231312);
			 ps.setObject(5, "1998-8-29");
			 ps.setObject(6, 3231);
			 ps.setObject(7, 313);
			 ps.setObject(8, 12);
			 ps.addBatch();//加入批处理
			 ps.setObject(1, 22);
			 ps.setObject(2, "dad22ad");
			 ps.setObject(3,"sda2d");
			 ps.setObject(4, 2311312);
			 ps.setObject(5, "1998-8-29");
			 ps.setObject(6, 32311);
			 ps.setObject(7, 3123);
			 ps.setObject(8, 12);
			 ps.addBatch();//加入批处理
			 int[] batch = ps.executeBatch();
			 conn.commit();//提交
			for (int i : batch) {
				System.out.println(i);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
