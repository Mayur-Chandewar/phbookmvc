<%@page import="com.phbook.dto.Contact"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Contact</title>
<style type="text/css">
	table{
		border-collapse:collapse;
		font-size: x-large;
	
	}
	thead{
	    background-color: darkgrey;
		}
	
	}
</style>
</head>
<body>
	<%@ include file="menu.jsp" %>

	<div align="center">

	<h1>View All Contact</h1>
		<%
		String code = request.getParameter("c");
		String msg="";
		String color="";
		if(code!=null){
			switch(code){
			
			case "202":
					msg="Contact Deleted Successfully";
					color="green";
					break;
			

			case "502":
					msg="Contact Not Deleted/edited Plsese Try Again...";
					color="red";
					break;
			
			
			}
		}
	%>
		<h2 style="color: <%=color%>"><%=msg %></h2>
		

	
	<table border="2">
		<thead>
			<tr>
				<th> Name
				</th>
				<th> Contact
				</th>
				<th> Action
				</th>
			</tr>
		</thead>
		
		<tbody>
		<%
			List<Contact> list = (List<Contact>) request.getAttribute("contactList");
			for(Contact ct:list){
		%>
			<tr>
				<td><%=ct.getFname()%> <%=ct.getLname()%></td>
				<td><%=ct.getContact() %></td>
				<td>
					<a href="edit-contact?id=<%=ct.getId()%>">Edit</a> / 
					<a href="delete-contact?id=<%=ct.getId()%>">Delete</a>
				</td>
			
			</tr>
			
		<%
			}
		%>
		</tbody>
	
	
	
	</table>
	
	</div>
</body>
</html>