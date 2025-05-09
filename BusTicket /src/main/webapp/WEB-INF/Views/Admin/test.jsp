<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSTL Test</title>
</head>
<body>

<c:if test="${not empty user}">
    Welcome, ${user} ${lastName }!
</c:if>
 <c:if test="${empty user}">
        <h2>No user found.</h2>
    </c:if>
</body>
</html>
