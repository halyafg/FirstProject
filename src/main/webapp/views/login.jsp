<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 08-Mar-17
  Time: 1:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <my:title/>
    <link rel="stylesheet" href="/resources/css/style_form.css">
</head>
<body>
    <h1>Login page</h1>

    <div class="container">
        <form action="/loginprocessing" method="post">
            <label  for ="login">Login:</label>
            <input id="login" name="username" placeholder="Email" class="textbox" type="text" required />
            <label for ="password">Password:</label>
            <input id="password" name="password" placeholder="Password" class="textbox" type="password" required />

            <button name="submit" class="button" type="submit">Sign in!</button>
        </form>
    </div>
</body>
</html>
