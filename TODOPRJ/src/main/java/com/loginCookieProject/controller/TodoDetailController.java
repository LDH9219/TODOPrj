package com.loginCookieProject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginCookieProject.db.todo.TodoDAO;
import com.loginCookieProject.db.todo.TodoDTO;

@WebServlet("/todoDetail")
public class TodoDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int todoIndex = Integer.parseInt(request.getParameter("todoIndex"));
		
		TodoDAO todoDAO = new TodoDAO();
		TodoDTO todoDTO = todoDAO.getTodo(todoIndex);
		request.setAttribute("n", todoDTO);
		
		request.getRequestDispatcher("todoDetail.jsp").forward(request, response);
	}
}
