package com.zhou.servlet1;

import java.io.IOException;
import java.net.URLDecoder;


import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class test3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public test3() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ServletInputStream inputStream = request.getInputStream();//获取request对象的输入流,包含post请求参数
		byte[] b=	new byte[1024]; 
			int len = inputStream.read(b);	//读取输入流中的数据
			String string = new String(b,0,len);
			string=URLDecoder.decode(string, "utf-8");//设置中文乱码
			System.out.println(string);
			//输出内容
			//username=八戒&password=admin1234
			
	}

}
