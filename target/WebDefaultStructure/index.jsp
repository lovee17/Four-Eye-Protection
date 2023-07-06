<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<title>Index</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>

<body>
<br>


<h2 align = center> Hello <b><sec:authentication property="principal.username" var="user"/> </h2>

<sec:authentication property="principal.authorities" var="authorities" /></b>

<c:forEach items="${authorities}" var="authority" varStatus="vs">


<h4 align=center>User is: ${authority.authority}</h4>
<c:set var="userRole" scope="session" value="${authority.authority}" />
<c:set var="username" scope="session" value= "${user}" />

<c:choose>
  <c:when test="${authority.authority == 'Maker'}">
    <p>${userRole} Available</p>
    <jsp:forward page="makerHome/maker" />
  </c:when>
  <c:otherwise>
    <p>${userRole} Not available</p>
    <jsp:forward page="checkerHome/checker" />
  </c:otherwise>
</c:choose>

</c:forEach>


<br><br><br>

<div align= center>
<a  class="btn btn-primary btn-lg" href= "makerHome/maker" role="button">Maker</a>&nbsp &nbsp &nbsp &nbsp

<a  class="btn btn-primary btn-lg" href= "checkerHome/checker" role="button">Checker</a>
</div>

<br><br>

<h5 align=center><a class="btn btn-primary" href="logout" role="button">Logout</a></h5>

</body>
</html>

