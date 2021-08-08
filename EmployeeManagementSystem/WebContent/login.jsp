<!DOCTYPE html>   
<html>   
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title> Login Page </title>  
<style>   
Body {  
  font-family: Calibri, Helvetica, sans-serif;  
  background-color: white;  
}  
button {   
       background-color: #4CAF50;   
       width: 10%;  
        color: orange;   
        padding: 15px;   
        margin: 10px 0px;   
        border: none;   
        cursor: pointer;   
         }   
  
 input[type=text], input[type=password] {   
        width: 100%;   
        margin: 8px 0;  
        padding: 12px 20px;   
        display: inline-block;   
        border: 2px solid green;   
        box-sizing: border-box;   
    }  
 input[type=submit]{ 
 		width: 15%;  
        color: white;
        background-color: green;
    }
 
 .container {   
 		border: none;
        padding: 25px;   
        background-color: lightblue; 
        margin-left: 7cm; 
        margin-right: 7cm;
        margin-top: 2cm;
    }   
select {
	    width: 100%;   
        margin: 8px 0;  
        padding: 12px 20px;   
        display: inline-block;   
        border: 2px solid green;   
        box-sizing: border-box;  
}
</style>   
</head>    
<body>    
    <div align="center" > <h1><u> Welcome to Employee Management System!!! </u></h1> </div>   
    <form action="LoginServlet">  
        <div class="container"> 
            <label><b>UserID :</b></label>   
            <input type = "text" placeholder = "Enter UserID" name = "username" required = "required">  
            <label><b>Password :</b></label>   
            <input type = "password" placeholder = "Enter Password" name = "password" required = "required">   
            <label><b>Role :</b></label>
            <select name ="role" required = "required">
				<option value = "admin"> Administrator </option>
				<option value = "user"> User </option>
			</select>
    
            <input type ="submit" name = "Login" value = "login" />
        </div>   
    </form>
    
    <% if(request.getAttribute("message")!= null){ %>
      	$(message)
    <%}%>
    
</body>     
</html>  



    		 <%-- <c:if test=${invalid eq 'true'}"> invalid Credentials</c:if>
    		 
    		 <span style = "color:red"> <% request.getAttribute("message"); %></span>
    		<br />
     	--%>