package com.zhou.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;





public class DBUtils {

	private static String driverClassName = null;
	private static String url = null;
	private static String password = null;
	private static String username = null;
	static {
		Properties pro = new Properties();
		InputStream instram = DBUtils.class.getResourceAsStream("/info.properties");
		try {
			pro.load(instram);
			url = pro.getProperty("url");
			driverClassName = pro.getProperty("driverClassName");
			System.out.println(driverClassName);
			username = pro.getProperty("username");
			System.out.println(username);
			password = pro.getProperty("password");
			Class.forName(driverClassName);
			pro.clear();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	//获取链接
	
	public static Connection getConn() {
		Connection conn=null;
		try {
			 conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//关数据库
	public static void close(Connection conn) {
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
