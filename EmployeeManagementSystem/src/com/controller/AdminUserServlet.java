package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.dao.AdminUserActions;
import com.validation.ValidateInput;
import com.beans.Department;
import com.beans.User;

/**
 * Servlet implementation class AdminUserServlet
 */
public class AdminUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("empId"));
		User u = AdminUserActions.viewEmployeeFromDB(id);
		PrintWriter out = response.getWriter();
		if(u == null) {
			JOptionPane optionPane = new JOptionPane("No User Found with ID:" + id ,JOptionPane.WARNING_MESSAGE);
			JDialog dialog = optionPane.createDialog("Warning!");
			dialog.setAlwaysOnTop(true); // to show top of all other application
			dialog.setVisible(true); // to visible the dialog
		}
		else {
			out.println("UserId - " + u.getUserId() +"<br />");
			out.println("First Name - " + u.getFname() +"<br />");
			out.println("Last Name - " + u.getLname() +"<br />");
			out.println("DOB - " + u.getDob().toString() +"<br />");
			out.println("Email - " + u.getEmail() +"<br />");
			out.println("Department - " + u.getDep().getName()+"<br />");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("action").equalsIgnoreCase("delete")) {
			doDelete(request, response);
			return;
		}
		else if(request.getParameter("action").equalsIgnoreCase("update")) {
			doUpdate(request, response);
			return;
		}
		else if(request.getParameter("action").equalsIgnoreCase("view")) {
			doGet(request, response);
			return;
		}
		else {
			String firstName = request.getParameter("fname");
			String lastName = request.getParameter("lname");
			Date dob = java.sql.Date.valueOf(request.getParameter("dob"));
			String email = request.getParameter("email");
			Department dep = new Department(request.getParameter("dep"));
			
			if( !(ValidateInput.validateName(firstName) && ValidateInput.validateName(lastName) && 
					ValidateInput.validateDate(request.getParameter("dob")) && ValidateInput.validateEmail(email)))
			{
				JOptionPane optionPane = new JOptionPane("Input Error" ,JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("Warning!");
				dialog.setAlwaysOnTop(true); // to show top of all other application
				dialog.setVisible(true); // to visible the dialog
				response.sendRedirect("admin.jsp");
			}
			else {
			
				User e1 = new User(firstName,lastName, dob, email, dep);
				System.out.println(dep);
				System.out.println(e1);
				
				AdminUserActions.insertEmployeeinDB(e1, dep);
				
				JOptionPane optionPane = new JOptionPane("User Added Successfully",JOptionPane.INFORMATION_MESSAGE);
				JDialog dialog = optionPane.createDialog("Success!");
				dialog.setAlwaysOnTop(true); // to show top of all other application
				dialog.setVisible(true); // to visible the dialog
				response.sendRedirect("admin.jsp");
			}
		}
	}

	protected void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("empId"));
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		Date dob = java.sql.Date.valueOf(request.getParameter("dob"));
		String email = request.getParameter("email");
		Department dep = new Department(request.getParameter("dep"));
		
		User e1 = new User(firstName,lastName, dob, email, dep);
		AdminUserActions.updateEmployeeFromDB(id, e1);
		JOptionPane optionPane = new JOptionPane("User Successfully Updated",JOptionPane.INFORMATION_MESSAGE);
		JDialog dialog = optionPane.createDialog("Success!");
		dialog.setAlwaysOnTop(true); // to show top of all other application
		dialog.setVisible(true); // to visible the dialog
		response.sendRedirect("admin.jsp");
//		out.print("User Successfully Updated");
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("empid"));
		AdminUserActions.deleteEmployeeFromDB(id);
		JOptionPane optionPane = new JOptionPane("User Successfully Deleted",JOptionPane.INFORMATION_MESSAGE);
		JDialog dialog = optionPane.createDialog("Success!");
		dialog.setAlwaysOnTop(true); // to show top of all other application
		dialog.setVisible(true); // to visible the dialog
		response.sendRedirect("admin.jsp");
//		out.print("User Successfully Deleted");
		
	}

}
