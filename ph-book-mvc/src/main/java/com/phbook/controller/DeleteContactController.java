package com.phbook.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phboo.model.ContactModel;

@WebServlet("/delete-contact")
public class DeleteContactController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String i=request.getParameter("id");
		int id = Integer.parseInt(i);
		ContactModel model = new ContactModel();
		boolean result = model.deleteContact(id);
		
		if(result) {
			response.sendRedirect("get-all-contact?c=202");
		}else {
			response.sendRedirect("get-all-contact?c=502");
		}
		
	}

}
