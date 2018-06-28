<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  uri="http://www.srikanthtechnologies.com/june11"  prefix="tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <select>
    <tags:jobs3>
       <option value="${id}">${title} </option>
    </tags:jobs3>
 </select>
 <ul>
 <tags:jobs3>
    <li>${title}, ${min} </li> 
 </tags:jobs3>	
</ul>

</body>
</html>