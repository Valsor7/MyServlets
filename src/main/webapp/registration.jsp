<%--
  Created by IntelliJ IDEA.
  User: Yaroslav
  Date: 09.06.14
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="Style.css" type="text/css">
    <title>Registration form</title>
</head>
<body>
<section class="main">
    <form action="/form" method="post">
        <label id="head">Registration form</label>
        <label>First name</label>
        <input type="text" name="first" placeholder="Type here" required>
        <label>Last name</label>
        <input type="text" name="last" placeholder="Type here" required>
        <label>Email</label>
        <input type="email" name="email" placeholder="Type here" required>
        <label>Password</label>
        <input type="password" name="pass" placeholder="Type here" required="">
        <input id="btn" type="submit">
        <img src="files/java.png">
    </form>
    <button type="button" onclick="window.location='main.jsp';">Back</button>
</section>
</body>
</html>
