package com.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.RoleController;
import com.model.Role;
@WebServlet(urlPatterns = "/addRole")
public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = -2315059980681111929L;
	private RoleController roleController = new RoleController();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String roleId = request.getParameter("role_id");
		if(roleId == null || roleId.length() == 0) {
			response.getWriter().println("Wrong Data!");
			return;
		}

		roleController.delete(Integer.valueOf(roleId));
		response.sendRedirect("roles.jsp");
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String roleName = request.getParameter("user_role");
		if(roleName == null || roleName.length() == 0) {
			response.getWriter().println("Wrong Data!");
			return;
		}

		Role role = new Role();
		role.setName(roleName);

		Role savedRole = roleController.save(role);
		if (savedRole.getId() != null) {
			response.sendRedirect("roles.jsp");
		}
	}
}
