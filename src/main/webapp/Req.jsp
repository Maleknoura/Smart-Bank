<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Projet</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>CIN</th>
        <th>Status</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="request" items="${requests}">
        <tr>
            <td>${request.id}</td>
            <td>${request.type}</td>
            <td>${request.firstName}</td>
            <td>${request.lastName}</td>
            <td>${request.cin}</td>
            <td>
                <c:forEach var="requestState" items="${request.requestStates}">
                    ${requestState.state.type} <br /> <!-- Affiche le type du statut -->
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
