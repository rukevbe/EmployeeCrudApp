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
    <form:form method="POST" modelAttribute="employee" action="saveEmployee" > 
       <table>
           <tr> 
               <th colspan="2">EDIT EMPLOYEE DETAILS</th> 
           </tr> 
           
           <tr> 
           <form:hidden path="employeeID"/>
           <!--  
          <td>EmployeeID</td> 
          <td><form:input path="employeeID"/> </td> 
           </tr>
           -->
           <tr> 
           <td>Firstname</td>
           <td><form:input path="firstname" /></td>
           </tr> 
           <tr> 
           <td>Surname</td>
           <td><form:input path="surname" /></td>
           </tr> 
           <tr> 
           <td> Address </td>
           <td><form:input path="address" /> </td>
           </tr> 
           <tr> 
           <td> Email </td>
           <td><form:input path="email" /></td>
           </tr> 
           <tr> 
           <td> Phone </td>
           <td><form:input path="phone" /> </td>
           </tr> 
           <tr> 
           <td> Date of birth </td>
           <td><form:input path="date_of_birth" />  </td>
           </tr> 
           <tr> 
           <td>  gender</td>
           <td><form:input path="gender" /></td>
           </tr> 
           <tr> 
           <td>Salary  </td>
           <td><form:input path="salary" /> </td>
           </tr> 
           <tr> 
               <td colspan="2"><input type="submit" value="SAVE" class="blue-button" /></td>
           </tr> 
           </table>
   </form:form>
</body>
</html>
