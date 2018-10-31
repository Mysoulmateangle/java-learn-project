package com.zhou.servlet1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class test4 extends HttpServlet {
	//通过getparameter获取request请求参数
	private static final long serialVersionUID = 1L;
       
   
    public test4() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//设置编码格式 编码格式必须放在最前面
		response.setContentType("text/html;charset=utf-8");//设置响应的编码格式
		//这里的respose为什么用setContent,因为content是能作用在整个application下的
		String username = request.getParameter("username");//通过标签中的name属性进行获取reqest请求中的值
		String password = request.getParameter("password");
		
		System.out.println(username+password);
		response.getWriter().write(username+password);
		//输出结果 八戒admin1234
		//网页中输出的值 ??admin1234 所以还需要进行设置网页的编码
		//response.setContentType("text/html;charset=utf-8");设置后的结果
		//网页面输出的值 八戒admin1234
	}
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
