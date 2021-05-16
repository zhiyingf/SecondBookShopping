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
       height:175px;
       border:1px solid #00ff00;       
       margin-top:10px;
       margin-bottom:10px;       
       text-align:center;       
    }
    .search0{
       margin:10px auto;
       width:1000px;
       height:155px;            
       }
    .search01{
       float:left;
       width:230px;       
       margin-top:50px;
       margin-left:180px;
       text-align:left;
       margin-bottom:63px;
    }
    .search02{
       float:left;
       width:170px;
       height:30px;   
       text-align:left;  
       margin-top:50px;
       margin-left:10px;  
       margin-bottom:63px;    
    }
    .search03{
       float:left;
       width:100px;
       height:30px;
       text-align:left;
       margin-top:50px;
       margin-left:10px;
       margin-bottom:63px;
           }
    .search04{
       float:left;
       width:100px;
       height:30px;
       text-align:left;
       margin-top:50px;
       margin-left:10px;
       margin-bottom:90px;
       margin-bottom:63px;
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
    strong{
    margin-top:4px;
    }
  </style>
  <script type="text/javascript">
  function a(){
	  var spanlocal=document.getElementById("spanlocal");
	  var textnode=document.createTextNode("图书搜索");
	  spanlocal.appendChild(textnode);
  }
  </script>
</head>
<body onload="javascript:a()">
  <div class="bodyall">
    <div class="headall"><%@include file="commonHead.jsp"%></div>
    <div class="searchall">
      <%--主体部分  图书搜索--%>
      <div class="search0">
      <hr width="1000px"/>
      <form action="SearchBookServlet" method="post">      
       <div class="search01">
       请输入检索条件：<select name="keyfind01">
                <option value="bookname" selected>书名</option>
                <option value="author">作者</option>  
                <option value="order_number">订单号</option>
                <option value="category">分类</option>            
             </select>
       </div>
        <div class="search02">
        关键字：<input type="text" name="key" id="idinput" required/>   
        </div>               
            <div class="search03">
            <select name="keyfind02">
              <option value="opt1" selected>模糊搜索</option>
              <option value="opt2">精确搜索</option>
            </select>
            </div>
            <div class="search04">
              <input type="submit" class="btn" value="搜索"/>
            </div>      
      </form>     
      <hr width="1000px"/>       
      </div>      
    </div>
    <c:if test="${!empty bookList}">
    <div>
	    <%--主体部分  图书浏览 --%>	    
	    <div class="booklistall">
	      <strong>${search}</strong>
	      <hr/>
	      <%@include file="commonBookList.jsp"%>
	    </div>
    </div> 
    </c:if>      
  </div>
</body>
</html>



