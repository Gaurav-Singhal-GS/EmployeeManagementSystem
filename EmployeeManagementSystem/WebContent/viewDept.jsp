<%@ page language="java" contentType="text/html"%>
<%@ page import="java.text.*,java.util.*" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title> Department </title>  
<style>   
Body {  
  font-family: Calibri, Helvetica, sans-serif;  
  background-color: white;  
}  
 .container {   
 		border: none;
        padding: 25px;   
        background-color: lightblue; 
        margin-left: 7cm; 
        margin-right: 7cm;
        margin-top: 2cm;
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
 input[type=text], input[type=password] {   
        width: 100%;   
        margin: 8px 0;  
        padding: 12px 20px;   
        display: inline-block;   
        border: 2px blue;   
        box-sizing: border-box;   
    }
   </style>
</head>
   <body>    
    <div align="center" > <h1><u> View Department! </u></h1> </div>   
    <form action = "AdminDeptServlet" method = "POST">
    <input type="hidden" name="action" value="viewDep"/>
        <div class="container">   
            <label>Department ID : </label>   
            <input type="text" placeholder="Enter Department ID" name="depId" required> 
    
              
             <button style="margin-right: 16px; font-size: 15px" type="submit"> View </button>
        </div>   
    </form>     
</body>   
</html>