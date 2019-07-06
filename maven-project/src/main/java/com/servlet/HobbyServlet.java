package com.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.HobbyController;
import com.model.Hobby;
@WebServlet(urlPatterns = "/addHobby")
public class HobbyServlet extends HttpServlet {
	private static final long serialVersionUID = -2315059980681111929L;
	private HobbyController hobbyController = new HobbyController();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String hobbyId = request.getParameter("hobby_id");
		if(hobbyId == null || hobbyId.length() == 0) {
			response.getWriter().println("Wrong Data!");
			return;
		}

		hobbyController.delete(Integer.valueOf(hobbyId));
		response.sendRedirect("hobbies.jsp");
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String hobbyName = request.getParameter("hobby_name");
		if(hobbyName == null || hobbyName.length() == 0) {
			response.getWriter().println("Wrong Data!");
			return;
		}

		Hobby hobby = new Hobby();
		hobby.setName(hobbyName);
		System.out.println(hobbyName);

		Hobby savedHobby = hobbyController.save(hobby);
		if (savedHobby.getId() != null) {
			response.sendRedirect("hobbies.jsp");
		}
	}
}
