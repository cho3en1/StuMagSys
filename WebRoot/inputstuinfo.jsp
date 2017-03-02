<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'inputstuinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <jsp:include page="islogin.jsp" ></jsp:include>
  <body>
  	<form action="user/inputStuInfoServlet" method="post">
  		<table>
  			<tr><td colspan="2">录入学生信息</td></tr>
  			<tr>
  				<td>姓名:</td>
  				<td><input type="text" name="name"></td>
  			</tr>
  			<tr>
  				<td>性别:</td>
  				<td><input type="radio" name="sex" checked value="1">男
  					<input type="radio" name="sex" checked value="0">女</td>
  			</tr>
  			<tr>
  				<td>生日:</td>
  				<td><input type="text" name="birthday"></td>
  			</tr>
  			<tr>
  				<td>专业:</td>
  				<td><select name="major">
  						<option>软件工程</option>
  						<option selected>计算机科学与技术</option>
  						<option>信息管理</option>
  					</select>
  				</td>
  			</tr>
  			<tr>
  				<td>课程:</td>
  				<td><select name="course" multiple="multiple">
  						<option>计算机导论</option>
  						<option>数据结构</option>
  						<option>软件工程导论</option>
  						<option>计算机网络</option>
  						<option>操作系统原理</option>
  						<option>数据库原理</option>
  					</select>	
  				</td>
  			</tr>
  			<tr>
  				<td>爱好:</td>
  				<td>
  					<input type="checkbox" value="music" name="hobby">听音乐	
  					<input type="checkbox" value="book" name="hobby">看书	
  					<input type="checkbox" value="web" name="hobby">上网	
  				</td>
  			</tr>
  			<tr>
  				<td>
  					<input type="submit" value="提交">
  					<input type="reset" value="重置">
  				</td>
  			</tr>
  		</table>
  	</form>
  </body>
</html>
