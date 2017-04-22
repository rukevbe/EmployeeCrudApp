<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Edmark</title>
<style> .blue-button{ 
        background: #25A6E1; 
        padding:3px 5px; 
        color:#fff; 
        font-family:'Helvetica Neue',sans-serif;
        font-size:12px; 
        border-radius:2px; 
        -moz-border-radius:2px; 
        -webkit-border-radius:4px; 
        border:1px solid #1A87B9 } 
    table { font-family: "Helvetica Neue", Helvetica, sans-serif; width: 50%; } 
    th { background: SteelBlue; color: white; } 
    td,th{ border: 1px solid gray; width: 25%; text-align: left; padding: 5px 10px; }
</style>
</head>
<body>
    
</br> 
<h3>LIST OF EMPLOYEES</h3> 
${employee.firstname}
<c:if test=""> 
    <table class="tg"> 
        <tr> <th width="80">EMPLOYEE ID</th>
            <th width="120">firstname</th> 
            <th width="120">surname</th> 
            <th width="120">address</th> 
            <th width="120">email</th> 
            <th width="120">date of birth</th>
            <th width="120">phone</th>
            <th width="120">gender</th>
            <th width="120">salary</th> 
            <th width="60">Edit</th> 
            <th width="60">Delete</th>
        </tr> <c:forEach items="${employeeList}" var="employee"> 
            <tr> <td>${employee.id}</td> 
                <td>${employee.firstname}</td> 
                <td>${employee.surname}</td>
                <td>${employee.address}</td>
                <td>${employee.email}</td>
                <td>${employee.date_of_birth}</td>
                <td>${employee.phone}</td>
                <td>${employee.gender}</td>
                <td>${employee.salary}</td>
                <td> <a href="/edit?id=${employee.id}">Edit</a></td>
                <td> <a href="/delete?id=${employee.id}">Delete</a></td> 
            </tr> </c:forEach> 
    </table>
</c:if>


</body>
</html>

