<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 20.09.2016
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app>
<head>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.1.5/angular.js"></script>
</head>
<body>
<div>
    <label>Имя</label>
    <input type="text" ng-model="name">
    <hr>
    <h1>Привет, {{name}}</h1>
</div>
</body>
</html>
