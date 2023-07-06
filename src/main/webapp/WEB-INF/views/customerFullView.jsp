<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>

<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
crossorigin="anonymous">

</head>

<body>

<table class="table table-hover">
<thead>

<tr>
<th scope="col"></th>
<th scope="col">User Code</th>
<th scope="col">User Name</th>
<th scope="col">User Address1</th>
<th scope="col">User Address2</th>
<th scope="col">PinCode</th>
<th scope="col">Email Address</th>
<th scope="col">Record Status</th>
<th scope="col">Active/Inactive Flag</th>
<th scope="col">Create Date</th>
<th scope="col">Created By</th>
<th scope="col">Modified Date</th>
<th scope="col">Modified By</th>
<th scope="col">Authorized Date</th>
<th scope="col">Authorized By</th>
</tr>

<%--
<tr>
<th><spring:message code="lbl.customerCode" /></th>
<th><spring:message code="lbl.customerName"  /></th>
<th><spring:message code="lbl.customerAddress1" text="User Address1" /></th>
<th><spring:message code="lbl.customerAddress2" text="User Address2" /></th>
<th><spring:message code="lbl.customerPinCode" text="Pin code" /></th>
<th><spring:message code="lbl.emailAddress" text="Email" /></th>
<th><spring:message code="lbl.recordStatus" text="Status" /></th>
<th><spring:message code="lbl.Flag" text="Flag" /></th>
<th><spring:message code="lbl.createDate" text="Create Date" /></th>
<th><spring:message code="lbl.createdBy" text="Created By" /></th>
<th><spring:message code="lbl.modifiedDate" text="Modified Date" /></th>
<th><spring:message code="lbl.modifiedBy" text="Modified By" /></th>
<th><spring:message code="lbl.authorizedDate" text="Authorized Date" /></th>
<th><spring:message code="lbl.authorizedBy" text="Authorized By" /></th>
</tr>
--%>


</thead>

<tbody>
<tr>
<th scope="row"></th>
<td>
<c:out value="${item.getCustomerCode()}" />
</td>
<td>
<c:out value="${item.getCustomerName()}" />
</td>
<td>
<c:out value="${item.getCustomerAddress1()}" />
</td>
<td>
<c:out value="${item.getCustomerAddress2()}" />
</td>
<td>
<c:out value="${item.getCustomerPinCode()}" />
</td>
<td>
<c:out value="${item.getEmailAddress()}" />
</td>
<td>
<c:out value="${item.getRecordStatus()}" />
</td>
<td>
<c:out value="${item.getFlag()}" />
</td>

<td>
<c:out value="${item.createDate}" />
</td>

<td>
<c:out value="${item.createdBy}" />
</td>


<td>
<c:out value="${item.modifiedDate}" />
</td>


<td>
<c:out value="${item.modifiedBy}" />
</td>


<td>
<c:out value="${item.authorizedDate}" />
</td>


<td>
<c:out value="${item.authorizedBy}" />
</td>

</tr>

</tbody>
</table>
<br>
<div align = center>
<a class="btn btn-primary" href="/MakerCheckerBRD/makerHome/maker" role="button">Home</a>
<a class="btn btn-primary" href="/MakerCheckerBRD/logout" role="button">Logout</a>&nbsp &nbsp
</div>
</body>

</html>
