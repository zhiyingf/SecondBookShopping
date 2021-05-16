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
  <P>输入您的信息，带*号项必须填写：</P>
  <form action="RegisterServlet" Method="post">
  <strong>${message}</strong>
	<br>登录名称<input type=text name="logname" class="txt"/>*
	<br>真实姓名<input type=text name="realname" class="txt"/>*
	<br>设置密码<input type=password name="password" class="txt"/>*
	<br>电子邮件<input type=text name="email" class="txt"/>*
	<br>联系电话<input type=text name="phone" class="txt"/>*
	<br>通信地址<input type=text name="address" class="txt"/>*
	<br><Input type=submit name="g" value="注册" class="btn"/>
  </form>
  <a  href="<%=response.encodeURL("userLogin.jsp")%>">已注册？去登陆</a>
  </div>
</div>
</body>
</html>
