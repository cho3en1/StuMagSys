<%@ page import="io.github.cho3en1.model.StuInfo" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modifyonestu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    	StuInfo stu = (StuInfo)session.getAttribute("stu");
     %>
     <form action="student/modifyOneStuInfoServlet" method="post">
  		<table>
  			<tr><td colspan="2">录入学生信息</td></tr>
  			<tr>
  				<td>姓名:</td>
  				<td><input type="text" name="name" value="<%=stu.getName()%>"></td>
  			</tr>
  			<tr>
  				<td>性别:</td>
  				<td><input type="radio" name="sex" <%if(stu.getSex()==1) %>checked value="1">男
  					<input type="radio" name="sex" <%if(stu.getSex()==0) %>checked value="0">女</td>
  			</tr>
  			<tr>
  				<td>生日:</td>
  				<td><input type="text" name="birthday" value="<%=stu.getBirthday()%>"></td>
  			</tr>
  			<tr>
  				<td>专业:</td>
  				<td><select name="major">
  						<option <%if(stu.getMajor().equals("软件工程")) %> selected>软件工程</option>
  						<option <%if(stu.getMajor().equals("计算机科学与技术")) %> selected>计算机科学与技术</option>
  						<option <%if(stu.getMajor().equals("信息管理")) %> selected>信息管理</option>
  					</select>
  				</td>
  			</tr>
  			<tr>
  				<td>课程:</td>
  				<td><select name="course" multiple="multiple">
  						<option 
  						<%String course[]=stu.getCourse();
  								for(int i=0; i<course.length; i++) {
  									if(course[i].equals("计算机导论")) {%>
  										selected <%break;
  									}
  								}
  							 %>>计算机导论</option>
  						<option<%
  								for(int i=0; i<course.length; i++) {
  									if(course[i].equals("数据结构")) {%>
  										selected <%break;
  									}
  								}
  							 %>>数据结构</option>
  						<option<%
  								for(int i=0; i<course.length; i++) {
  									if(course[i].equals("软件工程导论")) {%>
  										selected <%break;
  									}
  								}
  							 %>>软件工程导论</option>
  						<option<%
  								for(int i=0; i<course.length; i++) {
  									if(course[i].equals("计算机网络")) {%>
  										selected <%break;
  									}
  								}
  							 %>>计算机网络</option>
  						<option<%
  								for(int i=0; i<course.length; i++) {
  									if(course[i].equals("操作系统原理")) {%>
  										selected <%break;
  									}
  								}
  							 %>>操作系统原理</option>
  						<option<%
  								for(int i=0; i<course.length; i++) {
  									if(course[i].equals("数据库原理")) {%>
  										selected <%break;
  									}
  								}
  							 %>>数据库原理</option>
  					</select>	
  				</td>
  			</tr>
  			<tr>
  				<td>爱好:</td>
  				<td>
  					<input type="checkbox" value="music" name="hobby"
  					<%String hobby[]=stu.getHobby();
  								for(int i=0; i<hobby.length; i++) {
  									if(hobby[i].equals("music")) {%>
  										checked <%break;
  									}
  								}
  							 %>
  					>听音乐	
  					<input type="checkbox" value="book" name="hobby"
  					<%
  								for(int i=0; i<hobby.length; i++) {
  									if(hobby[i].equals("book")) {%>
  										checked <%break;
  									}
  								}
  							 %>
  					>看书	
  					<input type="checkbox" value="web" name="hobby"
  					<%
  								for(int i=0; i<hobby.length; i++) {
  									if(hobby[i].equals("web")) {%>
  										checked <%break;
  									}
  								}
  							 %>
  					>上网	
  				</td>
  			</tr>
  			<tr>
  				<td>
  					<input type="submit" value="提交">
  					<input type="reset" value="重置">
  				</td>
  			</tr>
  			<tr>
  				<td>
  					<input type="hidden" name="id" value="<%=stu.getId()%>">
  				</td>
  				
  			</tr>
  		</table>
  	</form>
  </body>
</html>
