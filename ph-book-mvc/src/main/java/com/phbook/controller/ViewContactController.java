package com.phbook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phboo.model.ContactModel;
import com.phbook.dto.Contact;

@WebServlet("/get-all-contact")
public class ViewContactController extends HttpServlet {
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ContactModel model = new ContactModel();
		List<Contact> contacts = model.getAll();
		
		request.setAttribute("contactList", contacts);
		RequestDispatcher dis = request.getRequestDispatcher("view-contact.jsp");
		dis.forward(request, response);
	}

}
