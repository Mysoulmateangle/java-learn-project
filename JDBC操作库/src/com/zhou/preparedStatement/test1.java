package com.zhou.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.zhou.bean.emper;

public class test1 {
	//用JDBC prepareStatement查询数据
	public static void main(String[] args) {
		System.out.println("请输入empno的编号");
		Scanner scanner = new Scanner(System.in);
		String empno1 = scanner.next();
		PreparedStatement ps=null;
		Connection conn=null;
		ResultSet rs=null;
		List<emper> list = new ArrayList<emper>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://127.0.1:3306/javaee1805?useUncide=true&characterEncoding=utf-8", "root", "123456");
		String sql="select * from emp where empno=?";
		 ps = conn.prepareStatement(sql);
		 ps.setObject(1, empno1);
		  rs = ps.executeQuery();
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
				for (emper emper2 : list) {
					System.out.println(emper2);
				}
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			scanner.close();
			try {//关闭连接
				if(rs!=null){
					rs.close();
				}
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
