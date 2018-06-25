<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.ArrayList" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Languages</title>
</head>
<body>
	<h1>Languages</h1>
	<form action="langs.jsp">
		Language <input type="text" name="lang" /> <input type="submit"
			value="Add" />
	</form>

	<ul>
		<%
			String lang = request.getParameter("lang");
			if (lang == null)
				return;

			ArrayList<String> langs = (ArrayList<String>) application.getAttribute("langs");
			if (langs == null) {
				langs = new ArrayList<String>();
				application.setAttribute("langs", langs);
			}

			langs.add(lang);

			for (String l : langs)
				out.println("<li>" + l + "</li>");
		%>
	</ul>

</body>
</html>