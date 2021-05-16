<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <title>陕师大二手交易市场</title>
    <link href="CSSALL/sheetInput.css" rel="stylesheet" type="text/css" />
</head>
<body class="body1">
<div class="content0">
    <h1>陕师大二手书交易市场</h1>
    <div class="content01">
    <form action="LoginServlet" Method="post">
    <strong>${message}</strong><br/>
	<br>登录名称<Input type=text name="logname" required class="txt"/>
	<br>输入密码<Input type=password name="password" required class="txt"/>
	<br><Input type=submit name="g" value="登录" class="btn">
	</form>
	<a  href="<%=response.encodeURL("userRegister.jsp")%>">还没有注册？去注册</a>
    </div>
</div>
</body>
</html>