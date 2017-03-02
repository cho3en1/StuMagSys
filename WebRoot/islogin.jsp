<%@page import="io.github.cho3en1.model.UserTable"%>
<%@page import="io.github.cho3en1.service.UserService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
UserTable user=(UserTable)session.getAttribute("user");
if(user==null)
{
 %>
 
 <jsp:forward page="index.jsp"></jsp:forward>
 <%} %>
