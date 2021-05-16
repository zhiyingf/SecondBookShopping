<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.*"%>

<html>
<body>
    <%
        request.setCharacterEncoding("UTF-8");
        //获取表单中提交过来的值  
        String username = request.getParameter("username");
        //判断用户名是否为空
        if (username.trim().length() == 0) {
            //设置提示信息  
            request.setAttribute("msg", "请输入用户名");
            request.getRequestDispatcher("../login.jsp").forward(request,response);
            return;
        }
        //从applicaton作用域中取出用户列表  
        List<Object> users = (List<Object>) application.getAttribute("users");
        //如果该用户列表还不存在，实例化该用户列表 
        if (users == null) {
            users = new ArrayList<Object>();
        }
        //查看当前列表中是否包含当前的登陆用户  
        if (users.contains(username)) {
            //设置提示信息  
            request.setAttribute("msg", "该用户已经登陆，请重新登陆");
            request.getRequestDispatcher("../login.jsp").forward(request,response);
            return;
        }

        //将当前登陆用户名加入该用户列表 
        users.add(username);
        application.setAttribute("users", users);
        session.setAttribute("user", username);
        response.sendRedirect("main.jsp");
    %>
</body>
</html>
