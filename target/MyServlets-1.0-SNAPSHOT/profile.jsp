<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Yaroslav
  Date: 19.06.14
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/MainStyle.css" type="text/css">
    <title></title>
</head>
<body>
    <%  if (session.getAttribute("user") != null) {
            List userArr = (List) session.getAttribute("list");
            for (Object user : userArr){ %>
                <ul>
                    <li> <%= user %> </li>
                </ul>
    <%      }%>
            <form action="/logout" method="post">
                <input type="submit" value="logout"/>
            </form>
    <%    } else { %>
              <h1>You are not log in. Please go back and <a href="index.jsp">log in</a></h1>
    <%    }
    %>
</body>
</html>
