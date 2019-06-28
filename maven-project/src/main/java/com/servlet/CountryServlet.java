package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.CountryController;
import com.model.Country;

@WebServlet(urlPatterns = "/countryServlet")
public class CountryServlet extends HttpServlet {
	private static final long serialVersionUID = 3184775947752792910L;
	private CountryController countryController = new CountryController(); 

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String countryName = request.getParameter("country_name");
		Country country = new Country();
		country.setName(countryName);
		countryController.save(country);
		response.sendRedirect("countries.jsp");
	}	

}
