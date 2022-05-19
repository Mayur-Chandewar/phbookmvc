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

@WebServlet("/search-contact")
public class SearchController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname = request.getParameter("sname");
		
		Contact contact = new Contact();
		ContactModel model = new ContactModel();
		
		contact = model.searchByName(fname);
		
		if(contact.getFname()!=null)
		{
			request.setAttribute("contactdetail", contact);
			RequestDispatcher dis = request.getRequestDispatcher("search-by-first-name.jsp");
			dis.forward(request, response);
		}else {
			response.sendRedirect("search-by-first-name.jsp?c=203");
		}
	}

}
