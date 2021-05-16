<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<title></title>
<head><link href="CSSALL/BookList.css" rel="stylesheet" type="text/css" /></head>
</head>
<body>
<div><%@include file="../commonHead.jsp"%></div>
    <%
        String msg = (String) request.getAttribute("msg");
        if (msg == null) {
            msg = "";
        }
    %>
    <h1><%=msg%></h1>
    <form action="chatRoom/Deal_Login.jsp" method="post" name="loginForm">
        <p align="center">用户名:<input type="text" name="username" value="${currentUser.logname}"/> <br /> 
        <p align="center"><input type="submit" value="登录" />
    </form>
</body>
</html>
