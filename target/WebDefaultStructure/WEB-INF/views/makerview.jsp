<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
crossorigin="anonymous">

</head>

<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">

  <div class="collapse navbar-collapse" id="navbarSupportedContent" >
    <ul class="navbar-nav mr-auto">

      <li class="nav-item"  >
        <a class="nav-link disabled" >Maker Table</a>
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
<a class="btn btn-primary" href="/MakerCheckerBRD/makerHome/delete?code=${item.getCustomerCode()}&status=${item.getRecordStatus()}"><c:out value="Delete" /></a>
</td>
<td>
<a class="btn btn-primary" href="/MakerCheckerBRD/makerHome/modify?code=${item.getCustomerCode()}&status=${item.getRecordStatus()}"><c:out value="Modify" /></a>
</td>

</tr>
</c:forEach>

<c:forEach items="${customerMasterList}" var="item">
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
<a class="btn btn-primary" href="/MakerCheckerBRD/makerHome/delete?code=${item.getCustomerCode()}&status=${item.getRecordStatus()}" role="button"><c:out value="Delete" /></a>
</td>
<td>
<a class="btn btn-primary" href="/MakerCheckerBRD/makerHome/modify?code=${item.getCustomerCode()}&status=${item.getRecordStatus()}" role="button"><c:out value="Modify" /></a>
</td>

</tr>
</c:forEach>

</tbody>
</table>
<br>
<hr>
<div align= center>
<a  class="btn btn-primary" href= "/MakerCheckerBRD/makerHome/showForm" role="button">Add</a>
</div>
<br>
<h5 align=center><a class="btn btn-primary" href="logout" role="button">Logout</a></h5>

</body>
</html>