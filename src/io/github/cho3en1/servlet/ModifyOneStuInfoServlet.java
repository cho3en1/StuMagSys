package io.github.cho3en1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.github.cho3en1.model.StuInfo;
import io.github.cho3en1.service.StuService;

public class ModifyOneStuInfoServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public ModifyOneStuInfoServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
		
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StuInfo stu = new StuInfo();
		HttpSession session = request.getSession();
		stu.setId(Integer.parseInt(request.getParameter("id")));
		stu.setName(request.getParameter("id"));
		stu.setSex(Byte.parseByte(request.getParameter("id")));
		stu.setBirthday(request.getParameter("birthday"));
		stu.setMajor(request.getParameter("major"));
		stu.setCourse(request.getParameterValues("course"));
		stu.setHobby(request.getParameterValues("hobby"));
		try {
			if(new StuService().updateStuInofo(stu)) {
				response.sendRedirect("../modifyonestu_success.jsp");
			}else {
				response.sendRedirect("../modifyonestu.jsp");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
