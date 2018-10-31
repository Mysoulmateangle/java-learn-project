package com.zhou.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.zhou.bean.user;
import com.zhou.service.imp.userserviceimp;

/**
 * Servlet implementation class userServlet
 */
public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public userServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	userserviceimp userserviceimp=new userserviceimp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String username = request.getParameter("username");
			String action = request.getParameter("action");
			String password = request.getParameter("password");
			System.out.println(action);
			if (action.equals("login")) {
				user user = new user(username, password);
				com.zhou.bean.user u = userserviceimp.querylogin(user);
				System.out.println(u);
				if (u!=null) {
					request.getRequestDispatcher("userServlet?action=show");
				}
				else {
					response.sendRedirect("login.html");
				}
			}
			else if (action.equals("show")) {
					List<user> list = userserviceimp.queryList();
					request.setAttribute("list", list);
					response.sendRedirect("main.jsp");
			}
			else if (action.equals("add")) {
				 String username1 = request.getParameter("name");
				 String sex = request.getParameter("sex");
				 String age = request.getParameter("age");
				 String password1 = request.getParameter("password");
				 
				user user = new user(username1, password1, Integer.parseInt(age), sex);
					int add = userserviceimp.add(user);
					if (add==1) {
						request.getRequestDispatcher("userServlet?action=show");
					}
				
			}
			
			
	}

}
