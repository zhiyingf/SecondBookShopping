<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
<!--
购物车加减书
//-->
function changetext(booknumber,kind,bookid){ 
	alert("bookid:"+bookid);alert("kind:"+kind);alert("booknumber:"+booknumber);
	var nodepoint=document.getElementById(bookid);	
	var intbook=nodepoint.getAttribute("value");	
	if(kind==1){
		if(intbook>1){nodepoint.setAttribute("value",parseInt(intbook)-1);}
		else alert("最小为1");
	}
	else{
		//if(intbook<booknumber){
			nodepoint.setAttribute("value",parseInt(intbook)+1);
		//}
		//else alert("最大为"+booknumber);
	}
}
</script>

<c:if test="${!empty orderformBookList}">
<div  class="booklistfind">
<c:forEach items="${orderformBookList}" var="book" begin="${(orderformPageNos-1)*3 }" end="${orderformPageNos*3-1}">
<div class="booklist0">
  <div class="booklist01">
     <img width="125px" height="144px"  src="${book.bookImg }"/>
  </div>
  <div class="booklist02">
     <br>书&nbsp;&nbsp;&nbsp;&nbsp;名：&nbsp;&nbsp;&nbsp;&nbsp;${book.bookname}      
     <br>作&nbsp;&nbsp;&nbsp;&nbsp;者：&nbsp;&nbsp;&nbsp;&nbsp;${book.realname}     
     <br>用户名：&nbsp;&nbsp;&nbsp;&nbsp;${book.logname }    
     <br>价&nbsp;&nbsp;&nbsp;&nbsp;格：&nbsp;&nbsp;&nbsp;&nbsp;${book.price}     
     <br>电&nbsp;&nbsp;&nbsp;&nbsp;话：&nbsp;&nbsp;&nbsp;&nbsp;${book.phone}  
     <br>地&nbsp;&nbsp;&nbsp;&nbsp;址：&nbsp;&nbsp;&nbsp;&nbsp;${book.address}        
  </div>
  <div class="booklist03">
     <br>数&nbsp;&nbsp;&nbsp;&nbsp;量：&nbsp;&nbsp;&nbsp;&nbsp;${book.booknumber}
     <br>订单号：&nbsp;&nbsp;&nbsp;&nbsp;${book.order_number}<br/><br/>  
     <div class="orderformBuy">
       <%-- <form action="UpdateOrderFormServlet" Method="post">
         <input type="hidden" name="order_number1"  value="${book.order_number}" />  
         <input type="hidden" name="logname1"  value="${book.logname}" />
         <table border="1">                
           <tr>
             <th width="25px" height="25px"><button class="txt1" type="button" onclick="changetext(${book.booknumber},1,${book.order_number})">-</button></th>
             <th width="25px" height="25px"><input class="txt1" type="text" name="booknumber1" value="1" style="width:20px;" id="${book.order_number}"/></th>
             <th width="25px" height="25px"><button class="txt1" type="button" onclick="changetext(${book.booknumber},2,${book.order_number})">+</button></th>
             <th width="40px" height="25px"><input type="submit" value="修改" /></th>
            </tr>  
         </table>                          
       </form>--%>
       <a style="text-decoration: none;" href="ModifyPrebuy?order_number=${book.order_number}&logname=${book.logname}&kind=1">去购买</a> | 
       <a style="text-decoration: none;" href="ModifyPrebuy?order_number=${book.order_number}&logname=${book.logname}&kind=2">去删除</a>      
     </div>     
  </div>
</div>
<hr size="2px"/>
</c:forEach>
</div>
<div class="pages">
  <div class="pages01">
  <table class="pagestable" border="1">
    <tr>
      <td width="55px"><a style="text-decoration: none;" href="OrderFormListServlet?orderformPageNos=1" >首页</a></td>
      <td width="55px">
        <c:choose>
           <c:when test="${orderformPageNos>0 }"><a style="text-decoration: none;" href="OrderFormListServlet?orderformPageNos=${orderformPageNos-1}">上一页</a></c:when>
           <c:otherwise><a style="text-decoration: none;" href="OrderFormListServlet?orderformPageNos=1">上一页</a></c:otherwise>
        </c:choose>        
      </td>
      <td width="55px">
           <c:choose>
             <c:when test="${orderformPageNos <orderformCountPage}"><a style="text-decoration: none;" href="OrderFormListServlet?pageNos=${orderformPageNos+1 }">下一页</a></c:when>
             <c:otherwise><a style="text-decoration: none;" href="OrderFormListServlet?orderformPageNos=${orderformCountPage}">下一页</a></c:otherwise>             
           </c:choose>           
      </td>
      <td width="55px"><a style="text-decoration: none;" href="OrderFormListServlet?orderformPageNos=${orderformCountPage}">尾页</a></td>
      <td width="130px"><div>页码${orderformPageNos} / 共${orderformCountPage}页</div></td>
    </tr>
  </table>
  </div>
</div>
</c:if>
