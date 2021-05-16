<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>陕师大二手交易市场</title>
  <link href="CSSALL/orderformList.css" rel="stylesheet" type="text/css" />
  <link href="CSSALL/BookList.css" rel="stylesheet" type="text/css" />
  <script type="text/javascript">
  function a(){
	  var spanlocal=document.getElementById("spanlocal");
	  var textnode=document.createTextNode("购物车");
	  spanlocal.appendChild(textnode);
  }
  </script>
</head>
<body onload="javascript:a()">
<c:if test="${empty currentUser}">
<%response.sendRedirect("userLogin.jsp");%>
</c:if>
  <div class="bodyall">
    <div class="headall"><%@include file="commonHead.jsp"%></div>
    <%--主体部分  图书浏览 --%>
    <div class="booklistall"><%@include file="commonOrderform.jsp"%></div>
  </div>
</body>
</html>