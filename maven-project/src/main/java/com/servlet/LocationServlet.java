package com.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.LocationController;
import com.model.Location;
@WebServlet(urlPatterns = "/addLocation")
public class LocationServlet extends HttpServlet {
	private static final long serialVersionUID = -2315059980681111929L;
	private LocationController locationController = new LocationController();

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String locationName = request.getParameter("location_name");
		if(locationName == null || locationName.length() == 0) {
			response.getWriter().println("Wrong Data!");
			return;
		}
		
		String countryId = request.getParameter("country");
		/*
		 * Location location = new Location(); location.setName(locationName);
		 * location.setCountryId(Integer.valueOf(countryId));
		 */
		Location location = new Location(Integer.valueOf(countryId), locationName);

		Location savedLocation = locationController.save(location);
		if (savedLocation.getId() != null) {
			response.sendRedirect("locations.jsp");
		}
	}
}
