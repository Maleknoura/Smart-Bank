<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <link rel="stylesheet" href="assets/css/Modal.css">
    <title>Title</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Type</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>CIN</th>
        <th>Status</th>
        <th>Status History</th>
        <th>Edit Status</th>
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
                <c:choose>
                    <c:when test="${not empty request.requestStates}">
                        <c:set var="lastIndex" value="${fn:length(request.requestStates) - 1}" />
                        ${request.requestStates[lastIndex].state.stateType}<br>
                    </c:when>
                    <c:otherwise>
                        Aucun statut
                    </c:otherwise>
                </c:choose>
            </td>

            <td>
                <c:choose>
                    <c:when test="${not empty request.requestStates}">
                        <c:forEach var="state" items="${request.requestStates}">
                            ${state.state.stateType}<br>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        Aucun statut
                    </c:otherwise>
                </c:choose>
            </td>

            <td>
                <c:if test="${not empty request.requestStates}">
                    <button onclick="openModal('${request.id}', '${request.firstName}', '${request.requestStates[0].state.stateType}')">
                        Edit Status
                    </button>
                </c:if>
                <c:if test="${empty request.requestStates}">
                    <button disabled>Aucun statut à modifier</button>
                </c:if>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div id="statusModal">
    <div class="modal-content">
        <span class="close" onclick="closeModal()">&times;</span>
        <h2>Edit Status</h2>
        <form id="updateStatusForm" action="${pageContext.request.contextPath}/updateStatus" method="POST">

            <input type="hidden" id="idInput" name="requestId" />
            <br /><br />

            <label for="statusSelect">Select Status:</label>
            <select id="statusSelect" name="stateId">
                <option value="1">Pending</option>
                <option value="2">Cancelled</option>
                <option value="3">Accepted</option>
            </select>
            <br /><br />

            <label for="descriptionInput">Description:</label>
            <textarea id="descriptionInput" name="description" rows="4" cols="50" placeholder="Enter a description..."></textarea>
            <br /><br />

            <button type="submit">Submit</button>
        </form>
    </div>
</div>


<script src="assets/js/Modal.js"></script>

</body>
</html>
