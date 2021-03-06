<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 19-Mar-17
  Time: 0:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <my:title/>
    <link rel="stylesheet" href="/resources/css/style_table.css">
    <link rel="stylesheet" href="/resources/css/menu.css">
</head>
<body>
    <div class="page">
    <p>${principal}'s cabinet</p><br>

    <div class="navbar">
        <ul>
            <li><a class="bot" href="/">Головна</a></li>
            <li><sec:authorize access="hasRole('ROLE_USER')"><a class="bot activ" href="#">My cabinet </a></sec:authorize></li>
            <li><sec:authorize access="isAnonymous()"><a class="bot" href="/change/passwordpage">Змінити пароль</a></sec:authorize></li>
            <li class="logout"><sec:authorize access="isAuthenticated()"><a class="bot" href="/logout">Logout   </a></sec:authorize></li>
            </ul>
    </div><br>

    <h2>Куплені об'єкти</h2>
    <table>
        <thead>
        <tr class="tabl">

            <th>Квартири</th>
            <th>Комірки</th>
            <th>Паркінги</th>

        </tr>
        </thead>
        <tbody>

            <tr>

                <td><c:forEach items="${customer_sFlats}" var = "fl"><a href="/flat/inf/${fl.flatNumber}" >${fl.flatNumber}, </a></c:forEach></td>
                <td><c:forEach items="${customer_sPantries}" var = "pan">${pan.number}<br> </c:forEach></td>
                <td><c:forEach items="${customer_sParking}" var = "par">${par.number}, </c:forEach></td>

            </tr>

        </tbody>
    </table><br><br><br>


        <div class="c1">
            <h2>Графік виплат</h2>
            <table class="table_schedulle">
                <thead>
                <tr class="tabl">
                    <th>Дата</th>
                    <th>Сума, $_USA</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${schedules}" var = "s">
                    <tr>
                        <td>${s.date}</td>
                        <td class="money">${s.amountUSA}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="c2">
            <h2>Таблиця здійснених виплат</h2>
            <table>
                <thead>
                <tr class="tabl">

                    <th>Data</th>
                    <th>Сума, грн</th>
                    <th>Курс грн/дол</th>
                    <th>Сума, $_USA</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${payments}" var = "p">
                    <tr>

                        <td>${p.data}</td>
                        <td class="money">${p.amountGRN}</td>
                        <td class="money">${p.quoteUSA}</td>
                        <td class="money">${p.amountUSA}</td>

                    </tr>
                </c:forEach>
                <tr>
                    <th>Разом:</th>
                    <th></th>
                    <th></th>
                    <th class="money">${amountUSA}</th>
                </tr>
                </tbody>
            </table>
        </div>


    </div>
</body>

</html>
