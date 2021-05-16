<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>陕师大二手交易市场</title>
  <link href="CSSALL/BookList.css" rel="stylesheet" type="text/css" />
  <script type="text/javascript">
  function a(){
	  var spanlocal=document.getElementById("spanlocal");
	  var textnode=document.createTextNode("图书浏览");
	  spanlocal.appendChild(textnode);
  }
  </script>
</head>
<%if(session.isNew())
{response.sendRedirect("BookListServlet");} %>
<body onload="javascript:a()">
  <div class="bodyall">
    <div class="headall"><%@include file="commonHead.jsp"%></div>
        <%--图书浏览 --%>
    <div class="booklistall"><%@include file="commonBookList.jsp"%></div>
  </div>
</body>
</html>




