<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>陕师大二手书市场</title>
  <link href="CSSALL/sheetInput.css" rel="stylesheet" type="text/css" />
  <link href="CSSALL/BookList.css" rel="stylesheet" type="text/css" />
  <style >
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
  
.contentsheet01{
            width: 1020px;            
            float:left;
            border:1px solid #00ff00; 
            
            
}
.contentsheet02{
          width: 500px;
          margin:auto;
                           
}
.row{
width: 400px; 
margin:auto;  
text-align:left;
}
.radio{
width: 450px; 
margin-left:50px;  
text-align:left;
}
h1 {
            text-align: center;
            border-bottom: 1px solid black;
            line-height: 100px;
        }

        .content {
            width: 1020px;
            margin:10px auto;
            text-align: center;
            
        }

        input {
            margin-left: 0px;
            margin-top:5px;
            margin-bottom:5px;
            
        }

        .txt {
            width: 250px;
            height: 23px;            
        }

        .btn {
            width: 200px;
            height: 23px;
        }
  </style>
  <script type="text/javascript">
  function a(){
	  var spanlocal=document.getElementById("spanlocal");
	  var textnode=document.createTextNode("图书管理 > 发布书单");
	  spanlocal.appendChild(textnode);
  }
  </script>
</head>
<body onload="javascript:a()">
<c:if test="${empty currentUser}">
<%
//response.sendRedirect("userLogin.jsp");  
out.println("<BR>你还没有登录请先登录。经过3秒后，将自动跳转到登陆界面，进行登录");
response.setHeader("Refresh", "1;URL=userLogin.jsp");
%>
</c:if>
  <div class="bodyall">
    <div class="headall"><%@include file="commonHead.jsp"%></div>
    <div class="searchall">
      <%--主体部分  图书管理--%>
      <div class="search0">
      <hr width="1000px"/>
      <div class="search01">|><a style="text-decoration: none;" href="addbook.jsp">发布书单</a></div>
      <div class="search02">|><a style="text-decoration: none;" href="PreUpdateServlet?my=1">我的书单</a></div>          
      <hr width="1000px"/> 
      </div>      
    </div>
    <div class="content">
    <div class="contentsheet01">
        <div class="contentsheet02">
        <%--主体部分  表单 --%>
        <P>输入需发布的书单信息，带*号项必须填写：</P>
        <strong>${message}</strong>
		<FORM action="AddBookServlet" Method="post">
		<div class="row">订阅号<input type=text name="order_number" class="txt">*</div>
		<div class="row">书&nbsp;&nbsp;&nbsp;&nbsp;名<input type=text name="bookname" class="txt">*</div>
		<div class="row">作&nbsp;&nbsp;&nbsp;&nbsp;者<input type=text name="author" class="txt">*</div>
		<div class="row">出版社<input type=text name="publisher" class="txt">*</div>
		<div class="row">数&nbsp;&nbsp;&nbsp;&nbsp;量<input type=text name="booknumber" class="txt">*</div>
		<div class="row">单&nbsp;&nbsp;&nbsp;&nbsp;价<input type=text name="price" class="txt">*</div>
		<div class="row">图&nbsp;&nbsp;&nbsp;&nbsp;片<input type=text name="bookImg" class="txt">*</div>
		<div class="row">发布人<input type=text name="logname" value="${currentUser.logname }" class="txt">*</div>
		<div class="row">分&nbsp;&nbsp;&nbsp;&nbsp;类:</div>
		<div class="radio">
		<input type="radio" name="category" value="语言文字类" checked>语言文字类
		<input type="radio" name="category" value="哲学类">哲学类
		<input type="radio" name="category" value="社会科学类">社会科学类
		<input type="radio" name="category" value="政治类">政治类
		<input type="radio" name="category" value="法律类">法律类<BR>
		<input type="radio" name="category" value="经济类">经济类
		<input type="radio" name="category" value="文化类">文化类
		<input type="radio" name="category" value="教育类">教育类
		<input type="radio" name="category" value="体育类">体育类
		<input type="radio" name="category" value="艺术类">艺术类
		<input type="radio" name="category" value="历史类">历史类<BR>
		<input type="radio" name="category" value="地理类">地理类
		<input type="radio" name="category" value="天文学类">天文学类
		<input type="radio" name="category" value="生物学类">生物学类
		<input type="radio" name="category" value="医学卫生类">医学卫生类
		<input type="radio" name="category" value="农业类">农业类*
		</div>
		<BR><input type=submit name="g" value="提交" class="btn">
		</Form>
        </div>
    </div>
  </div>      
  </div>
</body>
</html>
  