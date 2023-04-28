<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>${n.todoTitle}</title>
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
.ui-datepicker-title{
        width: 185px;
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
    <form action="todoUpdate" method="post">
		<input type="text" value="${n.todoTitle}" class="in" name="todoTitle" style="font-weight:bold;">
   		<textarea id="todoList"  class="in" name="todoList" >${n.todoList}</textarea>
    	<input type="text" value="${n.todoEndDate}" class="in" name="todoEndDate" id="datepicker" >
    	<script>
  			$(function() {
  				$("#datepicker").datepicker({
   					dateFormat: "yy-mm-dd"
  				});
			});
		</script>
		<input type="hidden" value="${n.todoIndex}" name="todoIndex">
    	<input type="submit" value="수정" id="updateButton">
    </form>
    			    		
    </div>
</body>

</html>