package com.zhou.rollback;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.util.Properties;

public class rollback {
	// 回滚成功的操作，使用properties文件配置地址信息
	private static String driver = null;
	private static String url = null;
	private static String user = null;
	private static String password = null;
	static {//静态代码块 初始化数据
		Properties pro = new Properties();
		InputStream inStream = rollback.class.getClassLoader().getResourceAsStream("jdbcinfo.properties");
		
		/*方式一【采用反射的方式获取】:最常用的方式。常用于读取同一文件夹下的文件，若不在同一文件夹下，需要往上层找
        InputStream inputStream = this.getClass().getResourceAsStream("../../../../config.properties");//相对路径
        InputStream inputStream = this.getClaa().getClassLoader().getResourceAsStream("华融湘江的ID.txt");//获取类加载路径，读取src下的文件
        Properties properties = new Properties();
        properties.load(inputStream);
        System.out.println(properties.getProperty("password"));;
 
        /*方式二【采用ResourceBundle来获取本地资源】：只适用于资源文件在src下面的情况
        ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
        System.out.println(resourceBundle.getString("DMUserName"));
 
 
        /*方式三:以文件流的形式读取
        Properties properties = new Properties();
        properties.load(new FileReader("config.properties"));  
        System.out.println(properties.getProperty("password"));
        System.out.println(URLDecoder.decode(this.getClass().getResource("").getPath(),"utf-8"));//获取当前类所在的项目路径
		*/
        try {

			pro.load(inStream);
		 url = pro.getProperty("url");
		 driver = pro.getProperty("driver");
		 
		 user = pro.getProperty("user");
		 password = pro.getProperty("password");
		 try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
//		Savepoint sp = null;//设置回滚点
//		conn.rollback(sp);
//		System.out.println("回滚一波");
		PreparedStatement ps=null;
		Connection conn=null;
		try {
		
			 conn = DriverManager.getConnection(url, user, password);
			 System.out.println(url);
			conn.setAutoCommit(false);
			String sql = "select * from emp";
			 ps = conn.prepareStatement(sql);
			 ps.executeQuery();
		
			
			String sql1 = "select * from emp";
			 ps = conn.prepareStatement(sql1);
			 ps.executeQuery();
			conn.commit();
			System.out.println("查询成功");
		} catch (Exception e) {
			 //TODO Auto-generated catch block
			
			e.printStackTrace();
		} 
	}

}
