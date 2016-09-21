<%@ page import="model.Client" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app>
<head>
    <title>Clients</title>

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.11/angular.min.js"></script>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Отчество</th>
        <th>Дата рождения</th>
        <th>Номер счета</th>
    </tr>
    <%
        List<Client> clients = (List<Client>) request.getAttribute("clients");
        for (Client client:clients){%>
    <tr>
        <td><%=client.getId()%></td>
        <td><%=client.getName()%></td>
        <td><%=client.getSurname()%></td>
        <td><%=client.getPatronymic()%></td>
        <td><%=new SimpleDateFormat("dd-MM-yyyy").format(client.getBirthday())%></td>
        <td><%=client.getAccNumber()%></td>
        <td>Изменить</td>
        <td><form action="/del" method="post">
                <input type="hidden" name="id" value="<%=client.getId()%>"/>
                <input type="submit" value="Удалить"/>
            </form>
        </td>
    </tr>
    <%}
    %>
</table>

<form method="post" action="/add" >
    <table>
        <tr>
            <td><label for="Id" >Id</label></td>
            <td><input id="Id" name="Id" ng-model="id"/></td>
            <td><label><p>{{id}}</p></label></td>
        </tr>
        <tr>
            <td><label for="Surname">Surname</label></td>
            <td><input id="Surname" name="Surname"/></td>
        </tr>
        <tr>
            <td><label for="Name">name</label></td>
            <td><input id="Name" name="Name"/></td>
        </tr>
        <tr>
            <td><label for="Patronymic">Patronymic</label></td>
            <td><input id="Patronymic" name="Patronymic"/></td>
        </tr>
        <tr>
            <td><label for="Birthday">Birthday</label></td>
            <td><input id="Birthday" name="Birthday"/></td>
        </tr>
        <tr>
            <td><label for="AccNum">Account Number</label></td>
            <td><input id="AccNum" name="AccNum"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>