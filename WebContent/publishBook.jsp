<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>陕师大二手交易市场</title>
  <link href="CSSALL/BookList.css" rel="stylesheet" type="text/css" />
  <style type="text/css">
    .searchall{       
       width:1020px;
       height:170px;
       border:1px solid #00ff00;       
       margin:20px auto;
       text-align:center;    
       
    }
    .search0{
       margin:10px auto;
       width:1000px;
       height:120px;   
       font-family: 隶书;
	   font-size: 24px;
	   letter-spacing: 3px;	
	   
       }
    .search01{       
       margin-top:40px;
       margin-bottom:10px;
    }
    .search02{       
       margin-bottom:40px;
    }
    
    select{
       width:100px;
       height:30px;
    }
    input{
       width:100px;
       height:30px;
    }
    #idinput{
    height:25px;
    }
  </style>
  <script type="text/javascript">
  function a(){
	  var spanlocal=document.getElementById("spanlocal");
	  var textnode=document.createTextNode("图书管理 > 我的书单");
	  spanlocal.appendChild(textnode);
  }
  </script>
</head>
<body onload="javascript:a()">
<c:if test="${empty currentUser}">
<%response.sendRedirect("userLogin.jsp");%>
</c:if>
  <div class="bodyall">
    <div><%@include file="commonHead.jsp"%></div>
    <div class="searchall">
      <%--主体部分  图书管理--%>
      <div class="search0">
      <hr width="1000px"/>
      <div class="search01">|><a style="text-decoration: none;" href="addbook.jsp">发布书单</a></div>
      <div class="search02">|><a style="text-decoration: none;" href="PreUpdateServlet?my=1">我的书单</a></div>          
      <hr width="1000px"/> 
      </div>      
    </div>
    <c:if test="${!empty bookList}">
    <c:if test="${my==1}">
    <div>
	    <%--主体部分  图书浏览 --%>	  
	    <div class="booklistall">
	    <strong>${search}</strong>
	    <hr/>
	      <%@include file="commonMybook.jsp"%>
	    </div>
    </div> 
    </c:if>
    </c:if>      
  </div>
</body>
</html>



