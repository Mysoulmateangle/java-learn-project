package com.zhou.servlet1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class test5 extends HttpServlet {
	//定时刷新网页
	private static final long serialVersionUID = 1L;
       
   
    public test5() {
        super();
        // TODO Auto-generated constructor stub
    }
    int count=3;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("在"+count+"秒后进行跳转到百度");
		
		
		response.setHeader("refresh", "3;url=index.html");//3秒后刷新，然后定向到index.html网页
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
