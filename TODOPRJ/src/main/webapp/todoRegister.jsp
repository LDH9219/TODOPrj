<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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
      
        textarea {
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
    textarea{
   		cursor: default;
  		background-color: white;
  	  	resize:none;
	}
    </style>
    
     <% String errorMessage = (String) request.getAttribute("errorMessage");
       if (errorMessage != null) { %>
        <script>alert('<%= errorMessage %>');</script>
    <% } %>
  
   <script>
document.addEventListener("DOMContentLoaded", function() {
  var textarea = document.getElementById("todoList");

  function adjustTextareaHeight(textarea) {
    textarea.style.height = "1px";
    textarea.style.height = (25 + textarea.scrollHeight) + "px";
  }

  textarea.addEventListener("input", function() {
    adjustTextareaHeight(textarea);
  });

  adjustTextareaHeight(textarea);
});
</script>

   <script>
  $(function() {
    var currentDate = new Date();

    $("#datepicker").datepicker({
      dateFormat: "yy-mm-dd",
      minDate: currentDate,
    });

    $("form").on("input", function() {
      var title = $("input[name='todoTitle']").val();
      var list = $("textarea[name='todoList']").val();
      var endDate = $("input[name='todoEndDate']").val();

      if (title.trim() !== "" && list.trim() !== "" && endDate.trim() !== "") {
        $("#loginButton").prop("disabled", false);
      } else {
        $("#loginButton").prop("disabled", true);
      }
    });
  });
</script>

  
</head>

<body>
    <div>
        <h2>Todo List 작성</h2>
        <form method="post" action="todoRegister">
            <input type="text" placeholder="해야 할 일(제목)" class="in" name="todoTitle">
            <textarea placeholder="상세히" class="in" name="todoList"  id = "todoList" rows="15"></textarea>
            <input type="text" placeholder="마감일 설정" class="in" name="todoEndDate" id="datepicker">
            <input type="submit" id="loginButton" value="등록" disabled>
        </form>
    </div>
</body>

</html>
