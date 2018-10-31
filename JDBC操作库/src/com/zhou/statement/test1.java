package com.zhou.statement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zhou.bean.emper;

public class test1 {
	//使用数据库查询表中数据
	public static void main(String[] args) {
		Connection conn=null;
		ResultSet rs=null;
		Statement stm=null;
		List<emper> list = new ArrayList<emper>();
		try {
			Class.forName("com.mysql.jdbc.Driver");//获取驱动，能够使用DriverManager
			 conn = DriverManager.getConnection
		("jdbc:mysql://127.0.1:3306/javaee1805?useUnicode=true&characterEncoding=utf-8", "root", "123456");//获取连接地址设置编码格式，用户密码
			//useUNcide是用来统一编码是否
			  stm = conn.createStatement();//获取执行sql语句的对象
			 String sql = "select * from emp";
			rs = stm.executeQuery(sql);//获取结果集
			while (rs.next()) {
				
				int empno = rs.getInt("empno");//获取其中的值
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				String hiredate = rs.getString("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno=rs.getInt("deptno");
				String ename=rs.getString("ename");
				emper emper=new emper(empno, ename, job, mgr, hiredate, sal, comm, deptno);//封装成对象
				list.add(emper);//添加进集合
			}
				for (emper emper : list) {//遍历集合
					System.out.println(emper);
				}
			 
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			try {//关闭连接
				if(rs!=null){
					rs.close();
				}
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
