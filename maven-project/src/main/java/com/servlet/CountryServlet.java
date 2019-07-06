package com.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.CountryController;
import com.model.Country;
@WebServlet(urlPatterns = "/addCountry")
public class CountryServlet extends HttpServlet {
	private static final long serialVersionUID = -2315059980681111929L;
	private CountryController countryController = new CountryController();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String countryId = request.getParameter("country_id");
		if(countryId == null || countryId.length() == 0) {
			response.getWriter().println("Wrong Data!");
			return;
		}

		countryController.delete(Integer.valueOf(countryId));
		response.sendRedirect("countries.jsp");
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String countryName = request.getParameter("country_name");
		if(countryName == null || countryName.length() == 0) {
			response.getWriter().println("Wrong Data!");
			return;
		}
		String phone = request.getParameter("phone");
		String countryId = request.getParameter("country_id");
		
		Country country;
		if (countryId == null) {
			country = new Country();
		} else {
			country = countryController.getById(Integer.valueOf(countryId));
		}
		
		country.setName(countryName);
		country.setPhone(phone);

		Country savedCountry = countryController.save(country);
		if (savedCountry.getId() != null) {
			response.sendRedirect("countries.jsp");
		}
	}
}
