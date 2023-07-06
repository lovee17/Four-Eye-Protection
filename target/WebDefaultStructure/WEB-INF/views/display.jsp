<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Summary page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>


<h3>Customer Details are as: </h3>

<table class="table">
<tbody>

<tr>
<td>Customer code:</td>
<td>${customer.getCustomerCode()}</td>
</tr>

<tr>
<td>Customer name:</td>
<td>${customer.getCustomerName()}</td>
</tr>

<tr>
<td>Customer address1:</td>
<td>${customer.getCustomerAddress1()}</td>
</tr>

<tr>
<td>Customer address2:</td>
<td>${customer.getCustomerAddress2()}</td>
</tr>

<tr>
<td>Customer code:</td>
<td>${customer.getCustomerPinCode()}</td>
</tr>

<tr>
<td>Customer email:</td>
<td>${customer.getEmailAddress()}</td>
</tr>

<tr>
<td>Customer number:</td>
<td>${customer.getContactNumber()}</td>
</tr>

<tr>
<td>Customer contact person:</td>
<td>${customer.getPrimaryContactPerson()}</td>
</tr>

<tr>
<td>Record status:</td>
<td>${customer.getRecordStatus()}</td>
</tr>

<tr>
<td>Flag:</td>
<td>${customer.getFlag()}</td>
</tr>

<tr>
<td>Create date:</td>
<td>${customer.getCreateDate()}</td>
</tr>

<tr>
<td>Created by:</td>
<td>${customer.getCreatedBy()}</td>
</tr>

<tbody>
</table>
<h3> Do You want to save ?</h3>
&nbsp<a  class="btn btn-primary" href= "saveForm" role="button">Yes</a>&nbsp &nbsp
<a  class="btn btn-primary" href= "doNotSaveForm?code=${customer.getCustomerCode()}" role="button">No</a>
<br>
<h5 align=center><a class="btn btn-primary" href="logout" role="button">Logout</a></h5>
<hr>
</body>
</html>