<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.sql.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Salary</title>
</head>
<body>
	<h1>Update Salary</h1>
	<form action="updatesalary.jsp">
		Employee Id <br /> <input type="text" name="empid"
			value="${param.empid}" />
		<p />
		New Salary <br /> <input type="text" name="newsalary"
			value="${param.newsalary}" />
		<p />
		<input type="submit" value="Update" />
	</form>
	<p />

	<%
		String empid = request.getParameter("empid");
		if (empid == null)
			return; // stop JSP

 	    String newsalary = request.getParameter("newsalary");
	    Class.forName("oracle.jdbc.driver.OracleDriver");		 // Loading driver 
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")) {
				PreparedStatement ps = con.prepareStatement
						("update employees set salary = ? where employee_id = ?");
	            
	            ps.setString(1, newsalary);
	            ps.setString(2, empid);
	            
				int count = ps.executeUpdate();

				if (count == 1)
					out.println("Updated Successfully!");
				else
					out.println("Sorry! Employee Id Not Found!");
		}
		catch(Exception ex) {
			System.out.println("Error -->" + ex.getMessage());
			out.println("Sorry! Could not update due to error!");
		}
	%>

</body>
</html>