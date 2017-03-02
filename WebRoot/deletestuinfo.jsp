<%@page import="io.github.cho3en1.model.StuInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'displaystuinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <jsp:include page="islogin.jsp"></jsp:include>
  <body>

  	<%
  		List stus = (List)session.getAttribute("stus");
  		Iterator iter = stus.iterator();
  		
  	 %>
  	 <table>
  	 <tr><td>id</td><td>姓名</td><td>性别</td><td>出生日期</td><td>专业</td><td>课程</td><td>爱好</td></tr>
  	 <%
  	 	while(iter.hasNext()) {
  	 		StuInfo stu = (StuInfo)iter.next();
  	 		%>
  	 		<tr>
  	 			<td><%=stu.getId() %></td>
  	 			<td><%=stu.getName() %></td>
  	 			<td><% 
					if(stu.getSex()==1) {
						out.print("男");
					}else {
						out.print("女");
					}
					 %></td>
  	 			<td><%=stu.getBirthday() %></td>
  	 			<td><%=stu.getMajor() %></td>
  	 			<td><%=stu.getCourses() %></td>
  	 			<td><%=stu.getHobbys() %></td>
  	 			<td><a href=student/deleteStuInfoServlet?id=<%=stu.getId()%>>删除</a></td>
  	 		</tr>
  	 <%
  	 	}
  	  %>
  	 
  	 </table>
  </body>
</html>
