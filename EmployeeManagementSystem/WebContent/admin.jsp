<!DOCTYPE html>   
<html>   
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title> Admin Page </title>  
<style>  
 .container {   
 		border: none;
        padding: 25px;   
        background-color: lightblue; 
        margin-left: 7cm; 
        margin-right: 6cm;
        margin-top: 2cm;
    } 
Body {  
  font-family: Calibri, Helvetica, sans-serif;  
  background-color: white;  
}   
 form {   
        border: 3px solid #f1f1f1;  
        margin-left: 3cm; 
    }  
    
input[type=submit]{ 
 		width: 15%;  
        color: white;
        background-color: blue;
    } 
 b{
 padding-left:5em
 }
   
</style>   
</head>    
<body>    
    <div align="center"> <u><h1> Welcome Admin! </h1></u> </div>  
	<div class="container">
    <b> Employee &ensp;&nbsp; </b> :  
	<a href = "addUser.jsp"> <input type = "submit" name = "addUser" value = "Add" /></a> &nbsp;
	<a href = "editEmployee.jsp"> <input type = "submit" name = "editUser" value = "Edit" /></a> &nbsp;
	<a href = "viewEmployee.jsp"> <input type = "submit" name = "viewUser" value = "View" /></a> &nbsp;
	<a href = "delEmployee.jsp"> <input type = "submit" name = "deleteUser" value = "Delete" /></a>


	<br/>
	<br/>
    <b>    Department </b>:
    <a href = "addDept.jsp"> <input type = "submit" name = "addDepartment" value = "Add" /></a> &nbsp;
	<a href = "viewDept.jsp"> <input type = "submit" name = "viewDepartment" value = "View" /></a>
	
	<br/>
	<br/>
    <b>    Regulations &nbsp;</b>: 
    <a href = "createReg.jsp"><input type = "submit" name = "addReg" value = "Add" /></a> &nbsp;
	<a href = "viewReg.jsp"><input type = "submit" name = "viewReg" value = "View" /></a>
	</div>
</body>     
</html>  