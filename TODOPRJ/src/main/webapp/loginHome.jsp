<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored ="false" %>
<%@page import="java.util.List"%>
<%@page import="com.loginCookieProject.db.todo.TodoDTO"%>
<%@page import="com.loginCookieProject.db.todo.TodoDAO"%>
<%@page import="com.loginCookieProject.db.user.UserDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
 
<c:if test="${empty requestScope.userName}">
    <% response.sendRedirect("login.jsp"); %>
</c:if>

<!DOCTYPE html>
<html>
<head>
    <title>${requestScope.userName}의 홈 화면</title>
    <meta charset="UTF-8">
    <style>
        div {
            margin: auto;
            width: 300px;
            background-color: #EEEFF1;
            border-radius: 5px;
            text-align: center;
            padding: 20px;
        }

        input {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
            border-radius: 5px;
            border: none;
        }
        .in {
            margin-bottom: 10px;
        }

        #loginButton {
            background-color: #1BBC9B;
            margin-bottom: 30px;
        }

        a {
            text-decoration: none;
            color: #9B9B9B;
            font-size: 12px;
        }
     #TodoList {
 	 margin: 20px auto;
 	 width: 300px;
 	 background-color: #EEEFF1;
 	 border-radius: 5px;
 	 text-align: left;
 	 padding: 20px;
}
              table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align:center;
  padding: 5px;
  border-bottom: 1px solid #ddd;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}

hr {
  margin-top: 10px;
  margin-bottom: 10px;
  border: 0;
  border-top: 1px solid #000;
}
    </style>
  
     <script>
        function displayLogoutAlert() {
            alert("로그아웃 되었습니다");
        }
    </script>
  
</head>
<body>
	<div>
		<form method = "post" action = "logout">
		<h2>${requestScope.userName} 님 반갑습니다</h2>
		<input type="submit" id="loginButton" value="로그아웃" onclick="displayLogoutAlert()">
		</form>
	</div>
  
  <br>

  <div>
				<h2>${requestScope.userName}의 ToDo List</h2>
				<table>
					<thead>
						<tr>
							<th width="15%">번호</th>
      						<th width="55%">제목</th>
       						<th width="30%">마감일</th>
						</tr>
					</thead>
					<tbody>
					
				
					<c:forEach var="n" items="${list}" varStatus = "status">	
					<tr>
						<td align="center">${status.index + 1}</td>
						<td><a href="todoDetail?todoIndex=${n.todoIndex}" style="color:black;">${n.todoTitle}</a></td>
						<td align="center"> <fmt:formatDate value="${n.todoEndDate}" pattern="yy/MM/dd" /></td>
					</tr> 
					</c:forEach>	
					</tbody>
				</table>
        <form action="todoRegister.jsp" method="post">
          <input type="submit" value="일정 추가" id="loginButton">
          </form>
    <a href="todoRegister.jsp"></a>
	</div>
</body>

</html>