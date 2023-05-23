<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>회원가입 페이지</title>
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

    <% String errorMessage = (String) request.getAttribute("errorMessage");
       if (errorMessage != null) { %>
        <script>alert('<%= errorMessage %>');</script>
    <% } %>

    <script>
        function checkForm() {
            var userId = document.getElementById("userId").value;
            var userPwd = document.getElementById("userPwd").value;
            var userName = document.getElementById("userName").value;
            var userEmail = document.getElementById("userEmail").value;
            var submitButton = document.getElementById("loginButton");

            if (userId !== "" && userPwd !== "" && userName !== "" && userEmail !== "") {
                submitButton.disabled = false;
            } else {
                submitButton.disabled = true;
            }
        }
    </script>
</head>

<body>
    <div>
       <form method="post" action="register">
            <input type="text" placeholder="아이디" class="in" name="userId" id="userId" oninput="checkForm()">
            <input type="password" placeholder="비밀번호" class="in" name="userPwd" id="userPwd" oninput="checkForm()">
            <input type="text" placeholder="이름" class="in" name="userName" id="userName" oninput="checkForm()">
            <input type="text" placeholder="Email" class="in" name="userEmail" id="userEmail" oninput="checkForm()">
          
            <input type="submit" id="loginButton" value="회원가입" disabled>
        </form>
    </div>
</body>

</html>
