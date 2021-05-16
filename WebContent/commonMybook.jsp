<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
function changetext(booknumber,kind,bookid){
	//alert("bookid:"+bookid);alert("kind:"+kind);alert("booknumber:"+booknumber);
	//var element=document.getElementById(bookid);
	var intbook=parseInt(document.getElementById(bookid).getAttribute("value"));
	alert("bookid:"+bookid);alert("kind:"+kind);alert("booknumber:"+booknumber);
	alert("boo"+intbook);
	alert("得到value");
	
	alert("value:"+intbook);
	if(kind=="1"){alert("kind==1");
		if(intbook>1){document.getElementById(bookid).setAttribute("value",intbook-1);}
		else alert("最小为1");
	}
	else{	alert("kind==2");
		if(intbook<parseInt(booknumber)){
			document.getElementById(bookid).setAttribute("value",intbook+1);			
		}
		else alert("最大为"+booknumber);
	}
}
</script>
<c:if test="${mybookList.size()>0}">
<div class="booklistfind" >
<%--<c:forEach items="${bookList}" var="book" begin="${(pageNos-1)*3+1}" end="${pageNos*3-1 > countPage ? countPage : pageNos*3-1}"> --%>
<c:forEach items="${mybookList}" var="book" begin="${(pageNos-1)*3 }" end="${(pageNos*3-1)}">
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
     <br>订单号：&nbsp;&nbsp;&nbsp;&nbsp;${book.order_number}<br/><br/>
     <c:if test="${!empty currentUser}">
     <div class="orderformBuy">          
       <%--<form action="AddOrderFormServlet" Method="post">
         <input type="hidden" name="order_number1"  value="${book.order_number}" />  
         <table border="1">                
           <tr>
             <th width="25px" height="25px"><button class="txt1" type="button" onclick="changetext(${book.booknumber},1,${book.order_number})">-</button></th>
             <th width="25px" height="25px"><input class="txt1" type="text" name="booknumber1" value="1" style="width:20px" id="${book.order_number}"/></th>
             <th width="25px" height="25px"><button class="txt1" type="button" onclick="changetext(${book.booknumber},2,${book.order_number})">+</button></th>
             <th width="40px" height="25px"><input type="submit" value="订购" /></th>
            </tr>  
         </table>                          
       </form>  --%>
       <a style="text-decoration: none;" href="PrechangeBook?order_number=${book.order_number}&mykind=1">更新书单</a> |
       <a style="text-decoration: none;" href="PrechangeBook?order_number=${book.order_number}&mykind=2">删除书单</a>           
     </div>
     </c:if>     
  </div>
</div>
<hr size="2px"/>
</c:forEach>
</div>
<div class="pages">
  <div class="pages01">
  <table class="pagestable" border="1">
    <tr>
      <td width="55px"><a style="text-decoration: none;" href="BookListServlet?pageNos=1" >首页</a></td>
      <td width="55px">
        <c:choose>
           <c:when test="${mypageNos>0 }"><a style="text-decoration: none;" href="BookListServlet?pageNos=${mypageNos-1}">上一页</a></c:when>
           <c:otherwise><a style="text-decoration: none;" href="BookListServlet?pageNos=1">上一页</a></c:otherwise>
        </c:choose>        
      </td>
      <td width="55px">
           <c:choose>
             <c:when test="${mypageNos <mycountPage }"><a style="text-decoration: none;" href="BookListServlet?pageNos=${mypageNos+1 }">下一页</a></c:when>
             <c:otherwise><a style="text-decoration: none;" href="BookListServlet?pageNos=${mycountPage}">下一页</a></c:otherwise>             
           </c:choose>           
      </td>
      <td width="55px"><a style="text-decoration: none;" href="BookListServlet?pageNos=${mycountPage}">尾页</a></td>
      <td width="130px"><div>页码${mypageNos} / 共${mycountPage}页</div></td>
    </tr>
  </table>
  </div>
</div>
</c:if>