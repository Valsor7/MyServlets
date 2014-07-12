 <%@ page import="com.sun.javafx.scene.control.skin.VirtualFlow" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Yaroslav
  Date: 17.06.14
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/MainStyle.css" type="text/css">
    <title></title>
</head>
<body>
    <div>
        <a href="registration.jsp">Registration</a>
        <form action="/login" method="post">
            <fieldset>
                <legend>Login form</legend>
                <label>Email</label>
                <input type="text" name="email" placeholder="email">
                <label>Password</label>
                <input type="password" name="pass" placeholder="password">
                <input type="submit" value="submit">
            </fieldset>
        </form>
        <%if (request.getAttribute("status") != null) {%>
            <label id="error"><%=request.getAttribute("status")%></label>
        <%}%>
    </div>
</body>
</html>
