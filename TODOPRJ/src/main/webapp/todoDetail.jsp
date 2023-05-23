<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>${n.todoTitle}</title>
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
             margin-bottom: 5px;
        }
		#delButton{
          background-color:#E63F1E;
          margin-bottom: 10px;
        }
        
        #updateButton{
          background-color:#62A5FC;
          margin-bottom: 20px;
        }
        
        a {
            text-decoration: none;
            color: #9B9B9B;
            font-size: 12px;
        }
textarea:disabled {
    cursor: default;
    background-color: white;
    resize:none;
}
      
input:disabled {
    cursor: default;
    background-color:white;
}
input::placeholder, textarea::placeholder {
  color: black;
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
		
</head>

<body>
    <div>
    <h2>ToDo List</h2>
		<input type="text" placeholder="${n.todoTitle}" class="in" name="todoTitle" disabled style="font-weight:bold;">
   		<textarea id="todoList" placeholder="${n.todoList}" class="in" name="todoList" disabled></textarea>
    	<input type="text" placeholder="마감일 : ${n.todoEndDate}" class="in" name="todoEndDate" id="datepicker" disabled>
    
    	<form action="login">
      		<input type="submit" value="목록" id="loginButton">
    	</form>
    
    	<form action="todoUpdate">
      		<input type="hidden" name="todoIndex" value="${n.todoIndex}">
      		<input type="submit" value="수정" id="updateButton">
    	</form>
    	<a href="todoUpdate.jsp"></a>
    
    	<form action="delTodoList" method="post" onsubmit="return confirm('정말로 삭제하시겠습니까? 되돌릴 수 없습니다.');">
      		<input type="hidden" name="todoIndex" value="${n.todoIndex}">
      		<input type="submit" value="삭제" id="delButton">
    	</form>
			    		
    </div>
</body>

</html>