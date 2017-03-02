package io.github.cho3en1.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.github.cho3en1.model.UserTable;
import io.github.cho3en1.service.UserService;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		UserTable user = new UserTable();
		UserService userservice = new UserService();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		try {
			if(userservice.userValidate(user)) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect("../main.jsp");
			}else {
				response.sendRedirect("../index.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		doPost(request, response);
	}
}
