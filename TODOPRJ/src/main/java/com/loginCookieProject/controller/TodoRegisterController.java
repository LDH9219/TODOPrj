package com.loginCookieProject.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginCookieProject.db.todo.TodoDAO;
import com.loginCookieProject.db.todo.TodoDTO;

@WebServlet("/todoRegister")
public class TodoRegisterController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("todoRegister.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		String userId = null;
		for (Cookie cookie : cookies) {
		    if (cookie.getName().equals("loginCookie")) {
		        userId = cookie.getValue();
		        break;
		    }
		}
		
		String todoTitle = request.getParameter("todoTitle");
		String todoList = request.getParameter("todoList");
		String todoEndDateStr = request.getParameter("todoEndDate");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = null;
		try {
		    utilDate = sdf.parse(todoEndDateStr);
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		TodoDTO todoDTO = new TodoDTO();
		todoDTO.setTodoTitle(todoTitle);
		todoDTO.setTodoUser(userId);
		todoDTO.setTodoList(todoList);
		todoDTO.setTodoEndDate(sqlDate);

		TodoDAO todoDAO = new TodoDAO();
		int result = todoDAO.insertTodoList(todoDTO);
		
		response.sendRedirect("login");
		}
}

