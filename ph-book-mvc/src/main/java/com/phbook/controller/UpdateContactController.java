package com.phbook.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phboo.model.ContactModel;
import com.phbook.dto.Contact;

@WebServlet("/update-contact-data")
public class UpdateContactController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contact ct = new Contact();
		//request.getParameter("");
		ct.setId(Integer.parseInt(request.getParameter("id")) );
		ct.setFname(request.getParameter("fname"));
		ct.setLname(request.getParameter("lname"));
		ct.setContact(request.getParameter("contact"));
		 ContactModel model = new ContactModel();
		 boolean result = model.update(ct);
		 if(result) {
				
				  RequestDispatcher dis = request.getRequestDispatcher("edit-contact?c=204");
				  dis.forward(request, response);
				 
				
		 }else {
			 response.sendRedirect("edit-contact.jsp?c=504");
		 }
		
	}

}
