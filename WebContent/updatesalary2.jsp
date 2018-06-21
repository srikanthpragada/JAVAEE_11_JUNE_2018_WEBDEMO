<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.sql.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Salary</title>
</head>
<body>
	<h1>Update Salary With Bean</h1>
	<form action="updatesalary2.jsp">
		Employee Id <br /> <input type="text" name="empid"
			value="${param.empid}" />
		<p />
		New Salary <br /> <input type="text" name="salary"
			value="${param.salary}" />
		<p />
		<input type="submit" value="Update" />
	</form>
	<p />

	<%
		String empid = request.getParameter("empid");
		if (empid == null)
			return; // stop JSP
	%>
	
	<jsp:useBean id="emp"  class="beans.EmployeeBean" scope="page"></jsp:useBean>
	<jsp:setProperty name="emp" property="*" />
	<%
	  if ( emp.process())
		  out.println("Updated Successfully!");
	  else
		  out.println("Sorry! Could not update employee details!");
	%>
	

</body>
</html>