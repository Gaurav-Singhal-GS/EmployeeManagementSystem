<%@ page language="java" contentType="text/html"%>
<%@ page import="java.text.*,java.util.*" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title> Employee </title>  
<style>   
Body {  
  font-family: Calibri, Helvetica, sans-serif;  
  background-color: white;  
}  
button {   
       background-color: #4CAF50;   
       width: 15%;  
        color: white;   
        padding: 15px;   
        margin: 10px 0px;   
        border: none;   
        cursor: pointer;   
         }   
 form {   
        border: 3px solid #f1f1f1;   
    }   
 input[type=text], input[type=password] {   
        width: 100%;   
        margin: 8px 0;  
        padding: 12px 20px;   
        display: inline-block;   
        border: 2px solid green;   
        box-sizing: border-box;   
    }
     .container {   
 		border: none;
        padding: 25px;   
        background-color: lightblue; 
        margin-left: 7cm; 
        margin-right: 7cm;
        margin-top: 2cm;
    }
   </style>
</head>
   <body>    
    <div align = "center"> <h1><u> View Employee Details! </u></h1> </div>   
    <form action = "AdminUserServlet" method = "POST">
    	<input type="hidden" name="action" value="view"/>  
        <div class="container">   
            <label>Employee ID : </label>   
            <input type="text" placeholder="Enter Employee ID" name="empId" required> 
    
              
             <button style="margin-right: 16px; font-size: 15px" type="submit"> View </button>
        </div>   
    </form>     
</body>   
</html>