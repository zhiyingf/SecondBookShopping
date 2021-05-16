<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.*"%>

<html>
<body>
    <%
        response.setHeader("refresh", "1");
        //从applicaton作用域中取出用户列表  
        List<Object> users = (List<Object>) application.getAttribute("users");
        out.print("目前在线的人有："+users.size()+"人");
        for (int i = 0; i < users.size(); i++) {
            String username = (String) users.get(i);
            out.print("<li>" + username);
        }
    %>
</body>
</html>
