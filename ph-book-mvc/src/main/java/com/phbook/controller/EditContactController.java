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


@WebServlet("/edit-contact")
public class EditContactController extends HttpServlet {
	

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String i = request.getParameter("id");
		int id = Integer.parseInt(i);
		
		Contact contact = new Contact();
		ContactModel model = new ContactModel();
		
		contact = model.getById(id);
		
		if(contact.getContact()!=null)
		{
			request.setAttribute("contactdetail", contact);
			RequestDispatcher dis = request.getRequestDispatcher("edit-contact.jsp");
			dis.forward(request, response);
		} 
			  else { response.sendRedirect("view-contact.jsp.jsp?c=502"); }
			 
	}

}
