<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title></title>
<link href="CSSALL/BookList.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
  function a(){
	  var spanlocal=document.getElementById("spanlocal");
	  var textnode=document.createTextNode("在线聊天室");
	  spanlocal.appendChild(textnode);
  }
  </script>

</head>
<body onload="javascript:a()">
<c:if test="${empty currentUser}">
<%response.sendRedirect("userLogin.jsp");%>
</c:if>
<div class="headall"><%@include file="commonHead.jsp"%></div>
    <%
        String msg = (String) request.getAttribute("msg");
        if (msg == null) {
            msg = "";
        }
    %>
    <div style="border:1px solid #00ff00;width:1020px;height:150px;margin:20px auto;">
    <hr width="1000px"/>
    <h1><%=msg%></h1>
    <form action="chatRoom/Deal_Login.jsp" method="post" name="loginForm">
        <p align="center">用户名:&nbsp;&nbsp;<input style="height:30px;width:150px" type="text" name="username" value="${currentUser.logname}" /> <br /> 
        <p align="center"><input style="height:30px;width:100px;margin-bottom:18px" type="submit" height="50px" value="登录" />
    </form>
    <hr width="1000px"/>
    </div>
</body>
</html>
