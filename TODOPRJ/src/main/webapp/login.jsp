<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>로그인 페이지</title>
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
    </style>
</head>
<% String errorMessage = (String) request.getAttribute("errorMessage");
if (errorMessage != null) { %>


<div style="color: red; font-size: 14px; margin-bottom: 10px;"><%= errorMessage %></div>
<% } %>

<body>
    <div>
       <form method = "post" action = "login">
            <input type="text" placeholder="아이디" class="in" name="userId">
          
            <input type="password" placeholder="비밀번호" class="in" name="userPwd">
          
            <input type="submit" id="loginButton" value="로그인">
        </form>
        <a href="register.jsp">회원가입</a>
    </div>
</body>

</html>