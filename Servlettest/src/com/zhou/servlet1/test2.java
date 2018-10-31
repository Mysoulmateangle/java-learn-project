package com.zhou.servlet1;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class test2 extends HttpServlet {
	//通过get方法进行接收请求参数获取参数字符串
	private static final long serialVersionUID = 1L;
       
   
    public test2() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String queryString = request.getQueryString();//获取请求的值
		queryString=URLDecoder.decode(queryString, "utf-8");//设置中文编码问题
		System.out.println(queryString);
		response.getWriter().write(queryString);//
		//获取的值
		//username%3D%25E5%2585%25AB%25E6%2588%2592%26password%3Dadmin1234
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
