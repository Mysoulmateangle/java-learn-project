package com.zhou.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class statementBatch {
	//使用statement对象进行批处理操作
	public static void main(String[] args) {
		Connection conn=null;
		Statement stm=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//获取驱动
		conn=DriverManager.getConnection("jdbc:mysql://127.0.1:3306/javaee1805?useUncide=true&characterEncoding=utf-8", "root", "123456");
		//建立连接
		stm = conn.createStatement();//创建执行sql语句的对象
		 conn.setAutoCommit(false);//取消自动提交
		 String sql="insert into emp values(211,'dad','dada',321,'2015-8-29',200,100,20)";
		stm.addBatch(sql);//添加到批处理
		String sql1="insert into emp values(212,'dad','dada',321,'2015-8-29',200,100,20)";
		 stm.addBatch(sql1);
		 String sql2="insert into emp values(213,'dad','dada',321,'2015-8-29',200,100,20)";
		 stm.addBatch(sql2);
		 int[] batch = stm.executeBatch();
		 conn.commit();//手动提交，使用连接对象进行提交
		 for (int i : batch) {
			System.out.print(i+"  ");//1  1  1   三个语句三个值
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
