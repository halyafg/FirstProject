<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 29-Mar-17
  Time: 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <my:title/>
    <link rel="stylesheet" href="/resources/css/menu.css">
    <link rel="stylesheet" href="/resources/css/style_form.css">
</head>
<body>

    <div class="container">
        <form action="/password/change" method="post">
            <input name="customerLogin" type="text" value="${userLogin}" hidden>

            <label for="password">Enter new password: </label>
            <input name="password" id="password" type="text"><br><br>

            <button type="submit"  class="button">Change!</button>

        </form>
    </div>
</body>
</html>
