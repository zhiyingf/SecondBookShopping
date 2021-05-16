<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>陕师大二手交易市场</title>
    <link href="CSSALL/sheetInput.css" rel="stylesheet" type="text/css" />
    <link href="CSSALL/BookList.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
  function a(){
	  var spanlocal=document.getElementById("spanlocal");
	  var textnode=document.createTextNode("我的账户");
	  spanlocal.appendChild(textnode);
  }
  </script>
</head>
<body onload="javascript:a()">
<c:if test="${empty currentUser}">
<%response.sendRedirect("userLogin.jsp");%>
</c:if>
<div class="content">
    <div class="headall">
    <%@include file="commonHead.jsp"%>
    </div>
  <div class="sheet">
  <P>输入您需要修改的信息，带*号项不能为空：</P>
  <form action="UserInfoUpdateServlet" Method="post">
    <strong>${message}</strong>
	<br>真实姓名<input type=text name="realname" class="txt" value="${currentUser.realname }"/>*
	<br>重置密码<input type=password name="password" class="txt" value="${currentUser.password }"/>*
	<br>确认密码<input type=password name="passwordAgain" class="txt" value="${currentUser.password }"/>*
	<br>电子邮件<input type=text name="email" class="txt" value="${currentUser.email }"/>*
	<br>联系电话<input type=text name="phone" class="txt" value="${currentUser.phone }"/>*
	<br>通信地址<input type=text name="address" class="txt" value="${currentUser.address }"/>*
	<br><Input type=submit name="g" value="提交修改" class="btn"/>
  </form>
  </div>
</div>
</body>
</html>
  