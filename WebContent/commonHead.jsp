<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="head0">
  <div class="head01">
        <div class="head011">陕师大二手书市场</div>
  </div>
        <div class="head02">
            <div class="headInfo">
            <c:choose>
                <c:when test="${!empty currentUser}">
                                                         当前登录：${currentUser.logname}
                   <a style="text-decoration: none;" href="LogoutServlet">退出系统</a>                                      
                </c:when>
                <c:otherwise>
                   <a style="text-decoration: none;" href="userLogin.jsp">用户登录</a> |
                   <a style="text-decoration: none;" href="userRegister.jsp">用户注册</a>
                </c:otherwise>
            </c:choose>
            </div>  
            <div class="headLocal">
            当前位置：<span id="spanlocal"></span>
            </div>          
        </div>                
  <div class="head03">
        <table class="headtable">
                <tr>
                    <td width="135px" height="40px" align="center"><a style="text-decoration: none;" href="<%=response.encodeURL("BookListServlet")%>">图书浏览</a></td>
                    <td width="135px"><a style="text-decoration: none;" href="<%=response.encodeURL("SearchBookServlet")%>">图书搜索</a></td>
                    <td width="135px"><a style="text-decoration: none;" href="<%=response.encodeURL("publishBook.jsp")%>">图书管理</a></td>
                    <td width="115px"><a style="text-decoration: none;" href="<%=response.encodeURL("OrderFormListServlet")%>">购物车</a></td>
                    <td width="135px"><a style="text-decoration: none;" href="<%=response.encodeURL("userInfoUpdate.jsp")%>">我的账户</a></td>
                    <td width="135px"><a style="text-decoration: none;" href="<%=response.encodeURL("login.jsp")%>">在线聊天室</a></td>
                </tr>
        </table>
  </div>
</div>






