<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Edmark</title>
<style>
.blue-button {
	background: #25A6E1;
	padding: 3px 5px;
	color: #fff;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 12px;
	border-radius: 2px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 4px;
	border: 1px solid #1A87B9
}

table {
	font-family: "Helvetica Neue", Helvetica, sans-serif;
	width: 50%;
}

th {
	background: SteelBlue;
	color: white;
}

td, th {
	border: 1px solid gray;
	width: 25%;
	text-align: left;
	padding: 5px 10px;
}
</style>
<script>
function generatePDFJasperChart(){
	var url  = "jasper";
	var strWindowFeatures = "menubar=no,location=no,width=800,height=500";
	window.open(url,"_blank", "location=0,height=500,width=800");
}
</script>
</head>
<body>
	</br>
	<h3>LIST OF EMPLOYEES</h3>
	</br>
	Registration Successful, <a href="/NelsonProject/newEmployee"> NEW REGISTRATON</a> 
        <a href=""  onclick="generatePDFJasperChart();">Generate Report</a>
	<c:if test="${not empty employeeList}">
		<ul>
			<c:forEach var="listValue" items="${list}">
				<li>${listValue}</li>
			</c:forEach>
		</ul>
	</c:if>
	<table class="tg">
		<tr>
			<th width="80">EmployeeID</th>
			<th width="120">Firstname</th>
			<th width="120">Surname</th>
			<th width="120">Address</th>
			<th width="120">Email</th>
			<th width="120">Phone</th>
			<th width="120">date of birth</th>
			<th width="120">Gender</th>
			<th width="120">Salary</th>
			<th width="60">Edit</th>
			<th width="60">Delete</th>
		</tr>
		<c:forEach items="${employeeList}" var="employee">
			<tr>
				<td>${employee.employeeID}</td>
				<td>${employee.firstname}</td>
				<td>${employee.surname}</td>
				<td>${employee.address}</td>
				<td>${employee.email}</td>
				<td>${employee.phone}</td>
				<td>${employee.date_of_birth}</td>
				<td>${employee.gender}</td>
				<td>${employee.salary}</td>
				<td><a href="editEmployee?id=${employee.employeeID}">Edit</a></td>
				<td><a href="deleteEmployee?id=${employee.employeeID}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>



</body>
</html>
