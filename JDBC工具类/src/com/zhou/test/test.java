package com.zhou.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.zhou.JDBCutils.baseDao;
import com.zhou.bean.emper;

public class test {
	//查询制定的empno的数据数据表信息
	public static void main(String[] args) {
		List<emper> list = new ArrayList<emper>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要查询的empno");
		String empno1 = scanner.next();
		Object[] parms= {Integer.parseInt(empno1)};
		String sql="select * from emp where empno=?";
		ResultSet rs = baseDao.query(sql, parms);
		try {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scanner.close();
	}

}
