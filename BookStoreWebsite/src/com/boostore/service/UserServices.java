package com.boostore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boostore.dao.UserDAO;
import com.boostore.entity.Users;

public class UserServices {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private UserDAO userDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public UserServices(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
				
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		userDAO = new UserDAO(entityManager);
	}

	public void listUser()
			throws ServletException, IOException {
		listUser(null);
	}

	public void listUser(String message)
			throws ServletException, IOException {
		List<Users> listUsers = userDAO.listAll();

		request.setAttribute("listUsers", listUsers);
		if (message != null) {
			request.setAttribute("message", message);

		}

		String listpage = "user_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listpage);

		requestDispatcher.forward(request, response);

	}

	public void createUser() {
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");

		Users newUser = new Users(email, fullName, password);
		userDAO.create(newUser);
	}
}
