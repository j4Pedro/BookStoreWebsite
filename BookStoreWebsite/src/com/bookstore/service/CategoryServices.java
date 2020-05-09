package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;

public class CategoryServices {
	private CategoryDAO categoryDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public CategoryServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		categoryDAO = new CategoryDAO(entityManager);
	}

	public void listCategory() throws ServletException, IOException {
		listCategory(null);
	}

	public void listCategory(String message) throws ServletException, IOException {
		List<Category> listCategory = categoryDAO.listAll();

		request.setAttribute("listCategory", listCategory);

		if(message != null) {
			request.setAttribute("message", message);
		}
		
		String listpage = "category_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listpage);

		requestDispatcher.forward(request, response);
	}

	public void createCategory() throws ServletException, IOException {
		String name = request.getParameter("name");
		Category existCategory = categoryDAO.findByName(name);

		if (existCategory != null) {
			String message = "建立失敗: " + name + " 已經存在";
			request.setAttribute("message", message);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);
		} else {
			Category newCategory = new Category(name);
			categoryDAO.create(newCategory);
			String message = "建立成功";
			listCategory(message);
		}
	}

	public void editCategory() throws ServletException, IOException {

		int categoryId = Integer.parseInt(request.getParameter("id"));
		Category category = categoryDAO.get(categoryId);
		String destPage = "category_form.jsp";
		
		if (category != null) {
			request.setAttribute("category", category);	
		} else {
			String message = "Could not find category with ID " + categoryId;
			request.setAttribute("message", message);
			destPage = "message.jsp";
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destPage);
		requestDispatcher.forward(request, response);

	}

	public void updateCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String categoryName = request.getParameter("name");
		
		Category categoryById = categoryDAO.get(categoryId);
		Category categoryByName = categoryDAO.findByName(categoryName);

		if (categoryByName != null && categoryById.getCategoryId() != categoryByName.getCategoryId()) {
			String message = "Could not Update: " + categoryName + "已存在";

			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);
		} else {
			categoryById.setName(categoryName);
			categoryDAO.update(categoryById);
			String message = "Updated successfully";
			listCategory(message);
		}

	}

	public void deleteCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		Category categoryById = categoryDAO.get(categoryId);
		
		if(categoryById == null) {
			String message = "CategoryID does not exist";
			listCategory(message);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);
		}else {
		categoryDAO.delete(categoryId);
		}
		String message = " Delete successfully ";
		listCategory(message);
		
	}

}
