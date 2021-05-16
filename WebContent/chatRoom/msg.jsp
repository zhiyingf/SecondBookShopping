<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.*"%>

<html>
<body>
    <%
        response.setHeader("refresh", "1");

        List<Object> msgs = (List<Object>) application.getAttribute("msgs");
        List<Object> to_sb = (List<Object>) application.getAttribute("private");
        List<Object> from_sb = (List<Object>) application.getAttribute("S_private");
        String user=(String)session.getAttribute("user");

        try{
            for (int i = 0; i < msgs.size(); i++) {
                String t1 = (String) msgs.get(i);
                String t2 = (String) to_sb.get(i);
                String t3 = (String) from_sb.get(i);

                if(t2.equals(user) || t2.equals("所有人") || t3.equals(user))
                    out.print(t1);
            }
        }catch(Exception e){}
    %>
</body>
</html>
