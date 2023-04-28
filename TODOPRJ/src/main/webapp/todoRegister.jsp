<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>TodoList 등록 페이지</title>
    <meta charset="UTF-8">
  
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.13.0/themes/smoothness/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.13.0/jquery-ui.min.js"></script>
  
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
		textarea{
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
      
      .ui-datepicker-title{
        width: 185px;
      }
      
    </style>
    
     <% String errorMessage = (String) request.getAttribute("errorMessage");
       if (errorMessage != null) { %>
        <script>alert('<%= errorMessage %>');</script>
    <% } %>
		
</head>

<body>
    <div>
    <h2>Todo List 작성</h2>
       <form method = "post"  action ="todoRegister">
            <input type="text" placeholder="해야 할 일(제목)" class="in" name="todoTitle">
            <textarea placeholder="상세히" class="in" name="todoList" ROWS="15" ></textarea>
         	<input type="text" placeholder="마감일 설정" class="in" name="todoEndDate" id = "datepicker">
<script>
  $(function() {
  $("#datepicker").datepicker({
    dateFormat: "yy-mm-dd"
  });
});
</script>
            <input type="submit" id="loginButton" value="등록">
        </form>
    </div>
</body>

</html>