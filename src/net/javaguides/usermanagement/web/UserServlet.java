package net.javaguides.usermanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.usermanagement.dao.UserDAO;
import net.javaguides.usermanagement.model.User;
import net.javaguides.usermanagement.service.IUserService;
import net.javaguides.usermanagement.service.UserService;

/**
 * ControllerServlet.java This servlet acts as a page controller for the
 * application, handling all requests from the user.
 */

@WebServlet("/")
public class UserServlet extends HttpServlet {// Singleton
	IUserService userService = UserService.getInstance(); // singleton, loose coupling

	public void init() {
//		userDAO = new UserDAO(); //code smell
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		System.out.println(hashCode());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
//			case "/delete":
//				deleteUser(request, response);
//				break;
			case "/edit":
				showEditForm(request, response);
				break;
//			case "/update":
//				updateUser(request, response);
//				break;
			default: // list
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userService.selectAllUsers();
		request.setAttribute("listUser1", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userService.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		User newUser = new User(name, email, country);
		userService.insertUser(newUser);
		if (true) {
			System.out.println("test");
		} else {
			System.out.println("else");// dead code
		}
		response.sendRedirect("list");
	}

	/*
	 * private void updateUser(HttpServletRequest request, HttpServletResponse
	 * response) throws SQLException, IOException { int id =
	 * Integer.parseInt(request.getParameter("id")); String name =
	 * request.getParameter("name"); String email = request.getParameter("email");
	 * String country = request.getParameter("country");
	 * 
	 * User book = new User(id, name, email, country); userDAO.updateUser(book);
	 * response.sendRedirect("list"); }
	 * 
	 * private void deleteUser(HttpServletRequest request, HttpServletResponse
	 * response) throws SQLException, IOException { int id =
	 * Integer.parseInt(request.getParameter("id")); userDAO.deleteUser(id);
	 * response.sendRedirect("list");
	 * 
	 * }
	 */
}
