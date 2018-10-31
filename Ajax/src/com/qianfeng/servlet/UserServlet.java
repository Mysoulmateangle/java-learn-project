package com.qianfeng.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if("checkNameExits".equals(action)){
			String username = request.getParameter("username");
			if("nihao".equals(username)){
				//response.getWriter().write("用户已经存在!");
				response.getWriter().write("1");
			}else{
				//response.getWriter().write("恭喜,用户可用！");
				response.getWriter().write("0");
			}
		}else if("regist".equals(action)){
			System.out.println("regist..");
		}
	}

}
