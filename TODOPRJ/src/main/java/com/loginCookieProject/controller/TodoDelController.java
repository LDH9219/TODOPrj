package com.loginCookieProject.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginCookieProject.db.todo.TodoDAO;

@WebServlet("/delTodoList")
public class TodoDelController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("todoDetail.jsp").forward(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int todoIndex = Integer.parseInt(request.getParameter("todoIndex"));
		
		TodoDAO todoDAO = new TodoDAO();
		try {
			int result = todoDAO.delTodoList(todoIndex);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("/login");
	}
}
