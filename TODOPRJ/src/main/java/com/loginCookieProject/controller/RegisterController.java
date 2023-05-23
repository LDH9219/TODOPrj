package com.loginCookieProject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginCookieProject.db.user.UserDAO;
import com.loginCookieProject.db.user.UserDTO;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String userId = request.getParameter("userId");
	    String userPwd = request.getParameter("userPwd");
	    String userName = request.getParameter("userName");
	    String userEmail = request.getParameter("userEmail");

	    if (userId.isEmpty() || userPwd.isEmpty() || userName.isEmpty() || userEmail.isEmpty()) {
	        request.setAttribute("errorMessage", "공백이 존재합니다. 모든 칸을 채워주세요.");
    	    request.getRequestDispatcher("register.jsp").forward(request, response);
	        return;
	    }

	    String trimUserId = userId.trim();
	    String trimUserPwd = userPwd.trim();
	    String trimUserName = userName.trim();
	    String trimUserEmail = userEmail.trim();

	    if (trimUserId.contains(" ") || trimUserPwd.contains(" ")
	            || trimUserName.contains(" ") || trimUserEmail.contains(" ")) {
	        request.setAttribute("errorMessage", "공백이 존재합니다. 모든 칸을 채워주세요.");
    	    request.getRequestDispatcher("register.jsp").forward(request, response);
	        return;
	    }
	    
	    if (trimUserId == null || trimUserId.isEmpty() || trimUserPwd == null || trimUserPwd.isEmpty() || 
	    	    trimUserName == null || trimUserName.isEmpty() || trimUserEmail == null || trimUserEmail.isEmpty()) {
	    	    request.setAttribute("errorMessage", "공백이 존재합니다. 모든 칸을 채워주세요.");
	    	    request.getRequestDispatcher("register.jsp").forward(request, response);
	    	    return;
    	}


	    UserDTO dto = new UserDTO();
	    if (trimUserId != null && !trimUserId.isEmpty() && !trimUserId.isBlank())
	        dto.setUserId(trimUserId);
	    if (trimUserPwd != null && !trimUserPwd.isEmpty() && !trimUserPwd.isBlank())
	        dto.setUserPwd(trimUserPwd);
	    if (trimUserName != null && !trimUserName.isEmpty() && !trimUserName.isBlank())
	        dto.setUserName(trimUserName);
	    if (trimUserEmail != null && !trimUserEmail.isEmpty() && !trimUserEmail.isBlank())
	        dto.setUserEmail(trimUserEmail);
	    
	    UserDAO dao = new UserDAO();
	    boolean result = dao.duplicateCheck(trimUserId);
	    
	    if(result == false) {
	    	int user = dao.regiCheck(dto);
	    	UserDAO dao_ = new UserDAO();
	    	String userName_ = dao.loginCheck(userId, userPwd);
	    		if (userName_ != null) {
	    			Cookie loginCookie = new Cookie("loginCookie", userId);
	    			loginCookie.setMaxAge(60 * 60 * 24);
	    			response.addCookie(loginCookie);

	    			System.out.println(userName_);
	    			request.setAttribute("userName", userName_);
	    			request.getRequestDispatcher("loginHome.jsp").forward(request, response);
	    		}
	    		response.sendRedirect("loginHome.jsp");
        
	    }else {
	    	request.setAttribute("errorMessage","중복된 ID는 사용하실 수 없습니다.");
	    	request.getRequestDispatcher("register.jsp").forward(request,response);
	    }
	   
	}
}	    
//	    UserDAO dao = new UserDAO();
//	    
//	    boolean result = dao.duplicateCheck(trimUserName);
//	    if(result == false) {
//	    	int user = dao.regiCheck(dto);
//	    	response.sendRedirect("login.jsp");
//	    }else {
//	    	request.setAttribute("errorMessage", "중복된 ID는 사용하실 수 없습니다.");
//            request.getRequestDispatcher("register.jsp").forward(request, response);
//        }
//
//	}
//}