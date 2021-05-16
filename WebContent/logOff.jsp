<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.*"%>

<html>
<body>
    <%
        //从applicaton作用域中取出用户列表  
        List<Object> users = (List<Object>)application.getAttribute("users");
        String username = (String) session.getAttribute("user");
        //从该用户列表中移除该用户  
        users.remove(username);
        application.setAttribute("users", users);
        //注销该用户的会话
        //session.invalidate();
        response.sendRedirect("login.jsp");
    %>
    
</body>
</html>