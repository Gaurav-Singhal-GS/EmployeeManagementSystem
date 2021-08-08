package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.dao.UserActions;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String id = request.getParameter("userId") ;
		System.out.println("UserID for regulations is "+ id);
		ArrayList<String> l = UserActions.viewRegulations(id);
		if(l.isEmpty()) {
			JOptionPane optionPane = new JOptionPane("No Regulation Found",JOptionPane.WARNING_MESSAGE);
			JDialog dialog = optionPane.createDialog("Warning!");
			dialog.setAlwaysOnTop(true); // to show top of all other application
			dialog.setVisible(true); // to visible the dialog
			response.sendRedirect("user.jsp");
		}
		else {
			for(String c: l) {
				out.print(c + "<br />");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("control").equalsIgnoreCase("view Reg")) {
			doGet(request, response);
		}
		else if(request.getParameter("control").equalsIgnoreCase("view")) {
			UserActions.viewComments(request.getParameter("userIdforcomments"));
			JOptionPane optionPane = new JOptionPane("No Comment Found",JOptionPane.WARNING_MESSAGE);
			JDialog dialog = optionPane.createDialog("Warning!");
			dialog.setAlwaysOnTop(true); // to show top of all other application
			dialog.setVisible(true); // to visible the dialog
			response.sendRedirect("user.jsp");
		}
		else {
			String comment = request.getParameter("comment");
			String regId = request.getParameter("idforcomment");
			String userId = request.getParameter("userIdforcomments");
			
			UserActions.addComments(comment, regId, userId);
			JOptionPane optionPane = new JOptionPane("User Comment Added",JOptionPane.WARNING_MESSAGE);
			JDialog dialog = optionPane.createDialog("Warning!");
			dialog.setAlwaysOnTop(true); // to show top of all other application
			dialog.setVisible(true); // to visible the dialog
			response.sendRedirect("user.jsp");
		}
	}

}
