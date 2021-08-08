<!DOCTYPE html> 
<html>   
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title> User Page </title>  
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
    
input[type=submit]{ 
 		width: 20%;  
        color: white;
        background-color: blue;
    } 
 b{
 padding-left:5em
 }
   
</style>   
</head>    
<body>    
    <div align = "center">  <h1><u> Welcome User! </u></h1> </div>
	<form action="UserServlet" method = "POST">
		<div class = "container">
			<b> View Regulations </b> : 
			<!--  <input type= "hidden" name = "userControls" value = "viewReg" /> -->
			<input type= "hidden" name = "userId" value = <%= request.getAttribute("userId") %> />
			<input type="submit" name="control" value="View Reg">
		    <br />
		    <br />
		
		    <b> Comments </b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:
		    <input type="submit" name="control" value="View">  &nbsp; 
		    <br />
		    <br />
		    
		    <div align ="center">
		    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    
		    <input type= "hidden" name = "userIdforcomments" value = <%= request.getAttribute("userId") %> />
		    <input type="text" placeholder="Enter Regulation ID" name="idforcomment" />
		    <input type="text" placeholder="Enter Your Comment" name="comment" />
		    <input type="submit" name="control" value="Update">
		    </div>
		    <br />
		    <br />
		    
		    <input type="button" name="login" value="Home Page" width="20%">
	    </div>
	</form>

</body>     
</html>  


			<!--  <%= request.getAttribute("userId") %>-->
			<!--  <%= request.getParameter("username") %>-->
			