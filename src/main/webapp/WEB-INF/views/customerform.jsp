<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>Customer Registration</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


<style>
.error {
	color: red;
}
</style>

</head>
<body>


	<div id="form"
		style="background-color: #FAFAC2; width: 60%; float: left; border: 2px solid black; padding-left: 30px; padding-right: 30px; margin-left: 200px; margin-top: 30px; text-align: centre;">

<h1>Customer Registration Form </h1>
<hr>
<form:form action="formsubmit" modelAttribute="customer">

Customer Code: <form:input  path="customerCode" /><br><br>
<form:errors path="customerCode" cssclass="error" />
<br>

Customer Name: <form:input path="customerName" /><br><br>
<form:errors path="customerName" cssclass="error" />
<br><br>

Customer Address 1: <form:input path="customerAddress1" /><br><br>
<form:errors path="customerAddress1" cssclass="error" />
<br><br>

Customer Address 2: <form:input path="customerAddress2" /><br><br>
<form:errors path="customerAddress2" cssclass="error" />
<br><br>

Customer Pin Code: <form:input path="customerPinCode" /><br><br>
<form:errors path="customerPinCode" cssclass="error" />
<br><br>

Customer Email Address: <form:input path="emailAddress" /><br><br>
<form:errors path="emailAddress" cssclass="error" />
<br><br>

Customer Contact Number: <form:input path="contactNumber" /><br><br>
<form:errors path="contactNumber" cssclass="error" />
<br><br>

Primary Contact Person: <form:input path="primaryContactPerson" /><br><br>
<br><br>


Flag : <form:select path="flag">
<form:option value="Active"></form:option>
<form:option value="Inactive"></form:option>
</form:select> <br><br>


<a  class="btn btn-primary" href= "maker" role="button">Cancel</a>&nbsp

<input type="submit" value="Save" name="save" class="btn btn-primary">&nbsp

<a  class="btn btn-primary" href= "showForm" role="button">Clear</a>



</form:form>

</div>

</body>
</html>
