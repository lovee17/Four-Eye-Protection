<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Update Form</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
crossorigin="anonymous">

</head>
<body>

	<div id="form" style="background-color: #FAFAD2; width: 60%; float: left; border: 2px solid black; padding-left: 30px; margin-left: 200px; margin-top: 30px; text-align: centre;">


<h1>Update Customer Form </h1>
<form:form action="modifyForm" modelAttribute="customer12">
<form:input path="customerCode" type="hidden" /><br><br>
Customer Name: <form:input path="customerName" /><br><br>
Customer Address 1: <form:input path="customerAddress1" /><br><br>
Customer Address 2: <form:input path="customerAddress2" /><br><br>
Customer Pin Code: <form:input path="customerPinCode" /><br><br>
Customer Email Address: <form:input path="emailAddress" /><br><br>
Customer Contact Number: <form:input path="contactNumber" /><br><br>
Primary Contact Person: <form:input path="primaryContactPerson" /><br><br>
Flag : <form:select path="flag">
<form:option value="Active"></form:option>
<form:option value="Inactive"></form:option>
</form:select> <br><br>
<form:input path="recordStatus" type="hidden" />
<form:input path="createDate" type="hidden" />
<form:input path="createdBy" type="hidden" />

<input type="submit" value="Update" name="update">
</form:form>

</div>


</body>
</html>
