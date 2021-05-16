<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.*"%>

<html>
<body>
    <form action="" method="post">
        <p align="right">
        <%=session.getAttribute("user")%>：发送消息给：

        <select name="select">
            <option value="0">所有人</option>
            <%
                List<Object> users = (List<Object>) application.getAttribute("users");
                for (int i = 0; i < users.size(); i++) { 
                    String username = (String) users.get(i); %>
                    <option value="<%=i+1 %>"><%=username %></option>
                <% } %>
        </select>
        <input type="text" name="message" size="50" /><br />

        <input type="submit" value="发送" />
        <input type="button" value="退出登录" onClick="parent.location.href='../logOff.jsp'"/>
    </form>
    <%
        String user=(String)session.getAttribute("user");
        request.setCharacterEncoding("UTF-8");
        String message = request.getParameter("message");

        String to="";
        try{
            //被发送消息方
            List<Object> tmp = (List<Object>) application.getAttribute("users");
            String SS = request.getParameter("select");
            int a=Integer.parseInt(SS);
            if(a==0) to="所有人";
            else to=(String)tmp.get(a-1);
        }
        catch(Exception e){}

        List<Object> msgs = (List<Object>) application.getAttribute("msgs");
        if (msgs == null) {
            msgs = new ArrayList<Object>();
        }
        List<Object> to_sb = (List<Object>) application.getAttribute("private");
        if (to_sb == null) {
            to_sb = new ArrayList<Object>();
        }
        List<Object> from_sb = (List<Object>) application.getAttribute("S_private");
        if (from_sb == null) {
            from_sb = new ArrayList<Object>();
        }


        if (message != null && !message.equals("")) {
            msgs.add(user + "发消息给" + to + "  :  " +message + "<br/>");
            to_sb.add(to);
            from_sb.add(user);

            application.setAttribute("msgs", msgs);
            application.setAttribute("private", to_sb);
            application.setAttribute("S_private", from_sb);
        }
    %>
</body>
</html>