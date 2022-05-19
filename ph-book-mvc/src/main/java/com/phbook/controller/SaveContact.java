package com.phbook.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phboo.model.ContactModel;
import com.phbook.dto.Contact;


@WebServlet("/new-contact")
public class SaveContact extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String number = request.getParameter("contact");
		
		Contact contact = new Contact();
		contact.setFname(fname);
		contact.setLname(lname);
		contact.setContact(number);
		
		ContactModel model = new ContactModel();
		boolean result = model.SaveContact(contact);
		
		if(result) {
			response.sendRedirect("new-contact.jsp?c=201");
			
		}
		else {
			response.sendRedirect("new-contact.jsp?c=501");
		}
		
		
	}

}
