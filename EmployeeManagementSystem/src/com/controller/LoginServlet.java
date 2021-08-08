package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.beans.Login;
import com.dao.UserValidation;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Login data = new Login(Integer.parseInt(request.getParameter("username")),request.getParameter("password"),request.getParameter("role"));
		System.out.println(data);
		if(data.getId() == 1 && data.getPassword().equalsIgnoreCase("admin") && data.getRole().equalsIgnoreCase("admin")) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		}
		else {
			if(request.getParameter("role").equalsIgnoreCase("admin")) {
				if(UserValidation.validateUsers(data)) {
					RequestDispatcher rd = request.getRequestDispatcher("/admin.jsp");
					rd.forward(request, response);
				}
				else {
					JOptionPane optionPane = new JOptionPane("Invalid UserID / Password",JOptionPane.WARNING_MESSAGE);
					JDialog dialog = optionPane.createDialog("Warning!");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true); // to visible the dialog
					response.sendRedirect("login.jsp");
				}
					
			}
			else {
				if(UserValidation.validateUsers(data)) {
					request.setAttribute("userId", request.getParameter("username"));
					RequestDispatcher rd = request.getRequestDispatcher("/user.jsp");
					rd.forward(request, response);
				}
				else {
					JOptionPane optionPane = new JOptionPane("Invalid UserID / Password",JOptionPane.WARNING_MESSAGE);
					JDialog dialog = optionPane.createDialog("Warning!");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true); // to visible the dialog
					response.sendRedirect("login.jsp");
				}
			}
		}
	}

}
