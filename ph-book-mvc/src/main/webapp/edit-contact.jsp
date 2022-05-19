<%@page import="com.phbook.dto.Contact"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit-contact(update)</title>
</head>
<body>
	<%@include file="menu.jsp" %>
	<%
		Contact ct= (Contact)request.getAttribute("contactdetail");
		/* int id = ct.getId();
		String fname= ct.getFname();
		String lname = ct.getLname();
		String contact = ct.getContact(); */
		String code = request.getParameter("c");
		String msg="";
		String color="";
		if(code!=null){
			switch(code){
				case "504":
					msg="Contact is not update please try again.";
					color="red";
					break;
				case "204":
					msg="Contact Updated";
					color="green";
					break;
			}
		}
	%>
	<div align="center">
	<h1>Update Details</h1>
	<hr>
	<h3 style="color: <%= color%>"><%=msg %></h3>
	
		<form action="update-contact-data">
			<input type="hidden" name="id" value=<%= ct.getId()%>> <br> <br>
			first Name : <input type="text" name="fname" value=<%= ct.getFname()%>> <br> <br>
			Last Name : <input type="text" name="lname" value=<%=ct.getLname()%>> <br> <br>
			Contact : <input type="text" name="contact" value=<%=  ct.getContact()%>> <br> <br>
			<button type="submit">Update</button>
			
		
		</form>
	
	</div>

</body>
</html>