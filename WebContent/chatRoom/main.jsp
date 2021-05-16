<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html>
<head>
<title></title>
</head>
<frameset rows="80%,*">
    <frameset cols="20%,*">
        <frame src="list.jsp"/>
        <frame src="msg.jsp"/>
    </frameset>
        <% response.setHeader("refresh", "10"); %>
        <frame src="send.jsp"/>
</frameset>
</html>
