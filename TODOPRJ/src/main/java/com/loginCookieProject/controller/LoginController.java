package com.loginCookieProject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginCookieProject.db.todo.TodoDTO;
import com.loginCookieProject.db.user.UserDAO;
import com.loginCookieProject.db.todo.TodoDAO;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        boolean loggedIn = false;
        String userId = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("loginCookie")) {
                    loggedIn = true;
                    userId = cookie.getValue();
                    break;
                }
            }
        }
        if (loggedIn) {
            UserDAO dao = new UserDAO();
            String userName = dao.getUserName(userId);
            String todoUser = userId;
            TodoDAO todoDAO = new TodoDAO();
            List<TodoDTO> list = todoDAO.getTodoList(todoUser);
            
            request.setAttribute("list",list);
            request.setAttribute("userName", userName);
            
            request.getRequestDispatcher("loginHome.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String userPwd = request.getParameter("userPwd");
        String todoUser = userId;
        
        UserDAO dao = new UserDAO();
        String userName = dao.loginCheck(userId, userPwd);

        if (userName != null) {
            Cookie loginCookie = new Cookie("loginCookie", userId);
            loginCookie.setMaxAge(60 * 60 * 24);
            response.addCookie(loginCookie);

            
           TodoDAO todoDAO = new TodoDAO();
            List<TodoDTO> list = todoDAO.getTodoList(todoUser);
            
            request.setAttribute("list",list);
            request.setAttribute("userName", userName);
            request.getRequestDispatcher("loginHome.jsp").forward(request, response);
            
            
            
        } else {
            String errorMessage = "아이디 또는 비밀번호가 일치하지 않습니다.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}