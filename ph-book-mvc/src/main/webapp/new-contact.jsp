<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Contact</title>
</head>
<body>

	<%@ include file="menu.jsp" %>
	
	<div align="center">
		<%
			String code = request.getParameter("c");
			String msg="";
			String color="";
			if(code!=null){
				switch(code){
					
				case "201":
						msg="Contact created Successfully";
						color="green";
						break;
					

				case "501":
						msg="Contact Creation Failed Please try again...";
						color="red";
						break;
					
				}
			}
			%>
			<h3 style="color: <%=color %>"><%=msg %></h3>
		<form action="new-contact">
			first Name : <input type="text" name="fname" > <br> <br>
			Last Name : <input type="text" name="lname"> <br> <br>
			contact : <input type="text" name="contact"> <br> <br>
			<button type="submit"> Create Contact</button> 
		</form>
	</div>

</body>
</html>