<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>

<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body>

<a href = "?lang=en_US">ENglish</a>
<a href = "?lang=zh_CN">Chinese</a>


<h2 align = center><b><sec:authentication property="principal.username" var="user"/> </h2>

<sec:authentication property="principal.authorities" var="authorities" /></b>

<c:forEach items="${authorities}" var="authority" varStatus="vs">

<h2 align = center>Hello ${user}</h2>
<c:set var="userRole" scope="session" value="${authority.authority}" />

<c:set var="username" scope="session" value= "${user}" />

</c:forEach>



<nav class="navbar navbar-expand-lg navbar-light bg-light">

  <div class="collapse navbar-collapse" id="navbarSupportedContent" align =center >
    <ul class="navbar-nav mr-auto">

      <li class="nav-item"  >
        <a class="nav-link disabled" >Checker Table</a>
      </li>

    </ul>
  </div>
</nav>


<table class="table table-hover">
<thead>
<tr>
<th scope="col"></th>
<th scope="col">User Code</th>
<th scope="col">User Name</th>
<th scope="col">User Address</th>
<th scope="col">Active/Inactive Flag</th>
<th scope="col">Status</th>
<th scope="col"></th>
<th scope="col"></th>
</tr>
</thead>
<tbody>
<c:forEach items="${customerList}" var="item">
<tr>
<th scope="row"></th>
<td>
<a href="/MakerCheckerBRD/makerHome/linkview?code=${item.getCustomerCode()}&status=${item.getRecordStatus()}"><c:out value="${item.getCustomerCode()}" /></a>
</td>
<td>
<c:out value="${item.getCustomerName()}" />
</td>
<td>
<c:out value="${item.getCustomerAddress2()}" />
</td>
<td>
<c:out value="${item.getFlag()}" />
</td>
<td>
<c:out value="${item.getRecordStatus()}" />
</td>
<td>
<a class="btn btn-primary" href="/MakerCheckerBRD/checkerHome/approve?code=${item.getCustomerCode()}&status=${item.getRecordStatus()}" role="button"><c:out value="Approve" /></a>
</td>
<td>
<a class="btn btn-primary" href="/MakerCheckerBRD/checkerHome/reject?code=${item.getCustomerCode()}&status=${item.getRecordStatus()}" role="button"><c:out value="Reject" /></a>
</td>

</tr>
</c:forEach>
</tbody>
</table>
<h5 align=center><a class="btn btn-primary" href="/MakerCheckerBRD/logout" role="button">Logout</a></h5>

</body>

</html>