package com.loginCookieProject.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginCookieProject.db.todo.TodoDAO;
import com.loginCookieProject.db.todo.TodoDTO;

@WebServlet("/todoUpdate")
public class TodoUpdateController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int todoIndex = Integer.parseInt(request.getParameter("todoIndex"));
		
		TodoDAO todoDAO = new TodoDAO();
		TodoDTO todoDTO = todoDAO.getTodo(todoIndex);
		request.setAttribute("n", todoDTO);
		
        request.getRequestDispatcher("todoUpdate.jsp").forward(request, response);
    }
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int todoIndex = Integer.parseInt(request.getParameter("todoIndex"));
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
        todoDTO.setTodoIndex(todoIndex);
        todoDTO.setTodoTitle(todoTitle);
        todoDTO.setTodoList(todoList);
        todoDTO.setTodoEndDate(sqlDate);
        
        TodoDAO todoDAO = new TodoDAO();
        int result = todoDAO.updateTodoList(todoDTO);
        
        response.sendRedirect("todoDetail?todoIndex=" + todoIndex);
    }
}
