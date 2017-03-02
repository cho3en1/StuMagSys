package io.github.cho3en1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.cho3en1.model.StuInfo;
import io.github.cho3en1.service.StuService;

public class InputStuInfoServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public InputStuInfoServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		byte sex = Byte.parseByte(request.getParameter("sex"));
		String birthday = request.getParameter("birthday");
		String major = request.getParameter("major");
		String courses[] = request.getParameterValues("course");
		String hobbys[] = request.getParameterValues("hobby");
		StuInfo stu = new StuInfo();
		stu.setName(name);
		stu.setSex(sex);
		stu.setBirthday(birthday);
		stu.setMajor(major);
		stu.setCourse(courses);
		stu.setHobby(hobbys);
		
		try {
			if(new StuService().addStuInofo(stu)) {
				response.sendRedirect("../inputStuInfo_success.jsp");
			}else {
				response.sendRedirect("../inputStuInfo.jsp");
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
