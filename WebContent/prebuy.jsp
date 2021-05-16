<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
<link href="CSSALL/BookList.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function a(kind){
	  var spanlocal=document.getElementById("spanlocal");
	  if(kind==1){
		  var textnode=document.createTextNode("图书浏览 >  加入购物车");  
	  }else{
		  var textnode=document.createTextNode("图书浏览 >  直接去购买");
	  }
	  spanlocal.appendChild(textnode);
}
function changetext(booknumber,kind){
	//alert("kind:"+kind);alert("booknumber:"+booknumber);
	var element=document.getElementById("id1");
	var intbook=parseInt(element.getAttribute("value"));		
	//alert("value:"+intbook);
	if(kind=="1"){//alert("kind==1");
		if(intbook>1){element.setAttribute("value",intbook-1);}
		else alert("最小为1");
	}
	else{	//alert("kind==2");
		if(intbook<parseInt(booknumber)){
			element.setAttribute("value",intbook+1);			
		}
		else alert("最大为"+booknumber);
	}
}
</script>
</head>
<body onload="javascript:a(${kind})">
  <div class="bodyall">
    <div class="headall"><%@include file="commonHead.jsp"%></div>
        <%--图书浏览 --%>
    <div class="booklistall"> 
<div class="booklistfind" >  
<div class="booklist0">        
  <div class="booklist01">
     <img width="125px" height="144px" src="${book.bookImg }"/>
  </div>
  <div class="booklist02">
     <br>书&nbsp;&nbsp;&nbsp;&nbsp;名：&nbsp;&nbsp;&nbsp;&nbsp;${book.bookname}   
     <br>作&nbsp;&nbsp;&nbsp;&nbsp;者：&nbsp;&nbsp;&nbsp;&nbsp;${book.author}
     <br>出版社：&nbsp;&nbsp;&nbsp;&nbsp;${book.publisher}
     <br>价&nbsp;&nbsp;&nbsp;&nbsp;格:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${book.price}
     <br>分&nbsp;&nbsp;&nbsp;&nbsp;类:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${book.category}
     <br>数&nbsp;&nbsp;&nbsp;&nbsp;量:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${book.booknumber}
  </div>
  <div class="booklist03">
     <br>发布人:&nbsp;&nbsp;&nbsp;&nbsp;${book.logname}
     <br>订单号：&nbsp;&nbsp;&nbsp;&nbsp;${book.order_number}
     <c:if test="${!empty currentUser}">
     <div class="orderformBuy">          
       <form action="AddOrderFormServlet" Method="post">
         <%--<input type="hidden" name="order_number1"  value="${book.order_number}" />   --%>
         <input type="hidden" name="kind" value="${kind}"/>
         <table border="1">                
           <tr>
             <th width="25px" height="25px"><button class="txt1" type="button" onclick="changetext(${book.booknumber},1)">-</button></th>
             <th width="25px" height="25px"><input class="txt1" type="text" name="booknumber1" value="1" style="width:20px" id="id1"/></th>
             <th width="25px" height="25px"><button class="txt1" type="button" onclick="changetext(${book.booknumber},2)">+</button></th>
             <c:choose>
             <c:when test="${kind==1}"><th width="40px" height="25px"><input type="submit" value="加入购物车" /></th></c:when>
             <c:otherwise><th width="40px" height="25px"><input type="submit" value="直接购买" /></th></c:otherwise>
             </c:choose>
            </tr>  
         </table>                          
       </form>  
       <strong>${message}</strong>       
       </div>
     </c:if>     
  </div>
</div> 
</div> 
</div>
<hr size="2px"/>
    </div>
</body>
</html>