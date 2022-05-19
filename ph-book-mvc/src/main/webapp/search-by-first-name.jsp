<%@page import="com.phbook.dto.Contact"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>search by first name</title>
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
	<%@include file="menu.jsp" %>
	<div align="center" >
		<h2>Search By First Name</h2>
		<%
			String code = request.getParameter("c");
			String msg = "";
			String color = "";
			if(code != null){
				switch(code){
				
				case "203":
					msg="Searched name is not available.";
					color="red";
					break;
				}
				
			}
					
		%>
		<h4 style="color: <%= color%>"><%= msg %></h4>
		<form action="search-contact">
			First Name : <input type="text" name="sname"> <br> <br>
			<button type="submit">Search</button>
		
		</form>
		
		<br>
		<br>
		<%
			if(request.getAttribute("contactdetail") !=null){
		%>		
		
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
				Contact ct = (Contact)request.getAttribute("contactdetail");
			%>
				<tr>
					<td><%=ct.getFname()%> <%=ct.getLname()%></td>
					<td><%=ct.getContact() %></td>
					<td>
						 <a href="delete-contact?id=<%=ct.getId()%>">Delete</a>
					</td>
				
				</tr>
				
			<%
				
			%>
			</tbody>
		
		
		
		</table>
		<%
		}
		%>		
	
	</div>

</body>
</html>