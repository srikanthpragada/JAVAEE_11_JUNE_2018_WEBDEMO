<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="javax.sql.rowset.*,oracle.jdbc.rowset.*"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees By Job</title>
</head>
<body>
	<h1>Employees By Job</h1>
	<form action="empbyjob.jsp">
		Job Id : <input type="text" name="jobid" value="${param.jobid}" /> 
		<input type="submit" value="Employees" />
	</form>
    <p/>

	<%
		String jobid = request.getParameter("jobid");
		if (jobid == null)
			return; // stop JSP 

		CachedRowSet rs = new OracleCachedRowSet();
		rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		rs.setUsername("hr");
		rs.setPassword("hr");
		rs.setCommand(
				"select first_name, salary, to_char(hire_date,'dd-MON-yyyy') hire_date,department_id from employees where job_id = ?");
		rs.setString(1, jobid);
		rs.execute();
	%>
	<table border="1" width="100%">
		<tr>
			<th>Name</th>
			<th>Salary</th>
			<th>HireDate</th>
			<th>Department</th>
		</tr>

		<%
			while (rs.next()) {
				out.println(String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>",
						rs.getString("first_name"), rs.getString("salary"), rs.getString("hire_date"),
						rs.getString("department_id")));
			}
		%>
	</table>

</body>
</html>