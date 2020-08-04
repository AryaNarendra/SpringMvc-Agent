<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Edit Agent</h1>
       <form:form action="/SpringMvcAgent/agent/editsave">  
      	<table >  
      	<tr>
      	<th>Agent ID</th>
         <td><form:input  path="agentId" readonly="readonly" /></td>
         </tr> 
         <tr>  
         <th>Agent Name</th>
          <td><form:input path="name"  /></td>
         </tr>  
         <tr>
        <th>City</th>
         	<td><form:input path="city"/></td>
         </tr>
         <tr>  
         <th>Gender</th>
          <td>
          Male<form:radiobutton path="gender" value="Male"/>
          Female<form:radiobutton path="gender" value="Female"/></td>
         </tr> 
         <tr>  
        <th>Marital Status</th>
          <td>
          Unmarried<form:radiobutton path="maritalStatus" value="0"/>
          Married<form:radiobutton path="maritalStatus" value="1"/></td>
         </tr>
         <tr>
         <th>Annual Premium</th>
         <td><form:input path="annualPremium" /></td>
         </tr>
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Edit Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
</body>
</html>