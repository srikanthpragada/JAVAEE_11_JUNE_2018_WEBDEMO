<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="javax.sql.rowset.*,oracle.jdbc.rowset.*"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Departments</title>
</head>
<body>
	<h2>Departments</h2>
	<hr/>
	<%
		CachedRowSet rs = new OracleCachedRowSet();
		rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		rs.setUsername("hr");
		rs.setPassword("hr");
		rs.setCommand("select * from departments");
		rs.execute();
		out.println("<ul>");
		while(rs.next()) {
			out.println( "<li>" + rs.getString("department_name") + "</li>");
		}
		out.println("</ul>");
	%>

</body>
</html>