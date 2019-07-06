package com.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.HobbyController;
import com.controller.RoleController;
import com.controller.UserController;
import com.model.Role;
import com.model.Hobby;
import com.model.User;
@WebServlet(urlPatterns = "/addUser")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = -2315059980681111929L;
	private UserController userController = new UserController();
	private RoleController roleController = new RoleController();
	private HobbyController hobbyController = new HobbyController();

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userName = request.getParameter("user_name");
		if(userName == null || userName.length() == 0) {
			response.getWriter().println("Wrong Data!");
			return;
		}
		String userAddress = request.getParameter("user_address");
		String userRoleId	= request.getParameter("user_role");
		System.out.println(userRoleId);
		String userHobbyId	= request.getParameter("user_hobby");
		
		User user = new User();
		user.setName(userName);
		user.setAddress(userAddress);
		user.setRoleId(Integer.valueOf(userRoleId));
		user.setHobbyId(Integer.valueOf(userHobbyId));
	
		User savedUser = userController.save(user);
		if (savedUser.getId() != null) {
			response.sendRedirect("users.jsp");
		}
	}
}
