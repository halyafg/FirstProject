<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10-Mar-17
  Time: 1:09
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
<h1>Edit customer page</h1>
<div class="container">
    <form action="/customer/edit" method="post">
        <input name="custId" value="${customer.id}" hidden>
        <input name="houseId" value="${houseId}" hidden>

        <label for="name">Name </label>
        <input name="name" id="name" class="textbox" type="text" value="${customer.name}">
        <label for="surname">Second name: </label>
        <input name="surname" id="surname" class="textbox" type="text" value="${customer.surname}">
        <label for="lastname">Last name: </label>
        <input name="lastname" id="lastname" class="textbox" type="text" value="${customer.lastname}">
        <label for="phone">Phone: </label>
        <input name="phone" id="phone" class="textbox" type="text" value="${customer.phone}">
        <label for="email">Email: </label>
        <input name="email" id="email" class="textbox" type="email" value="${customer.email}">
        <label for="password">Password*: </label>
        <input name="password" id="password" class="textbox" type="password" value="${customer.password}">

        <label for="pasportSerija">Pasport's serija: </label>
        <input name="pasportSeria" id="pasportSerija" class="textbox" type="text" value="${customer. pasportSeria}">
        <label for="pasportNumber">Pasport's number: </label>
        <input name="pasportNumber" id="pasportNumber" class="textbox" type="text" value="${customer.pasportNumber}">
        <label for="pasportVidan">Pasport kim vydan: </label>
        <input name="pasportKimVidan" id="pasportVidan" class="textbox" type="text" value="${customer.pasportKimVidan}">
        <label for="pasportdata">Pasport data vidachi: </label>
        <input name="pasportData" id="pasportdata" class="textbox"  type="text" value="${customer.pasportData}">

        <button type="submit" class="button">Edit!</button>
    </form>

</div>


</body>
</html>
