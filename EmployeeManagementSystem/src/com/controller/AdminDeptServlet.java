package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.beans.Department;
import com.dao.AdminDeptActions;

/**
 * Servlet implementation class AdminDeptServlet
 */
public class AdminDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("depId"));
		Department d = AdminDeptActions.viewDepartmentFromDB(id);
		PrintWriter out = response.getWriter();
		if(d != null) {
			out.print("Dept Id  :" + d.getId() + "<br />");
			out.print("Dept Name:" + d.getName());
		}
		else {
//			out.print("No Department with ID: " + id);
			JOptionPane optionPane = new JOptionPane("No Department with ID: " + id,JOptionPane.WARNING_MESSAGE);
			JDialog dialog = optionPane.createDialog("Warning!");
			dialog.setAlwaysOnTop(true); // to show top of all other application
			dialog.setVisible(true); // to visible the dialog
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("action").equalsIgnoreCase("addDep")) {
			Department name = new Department(request.getParameter("depName"));
			AdminDeptActions.insertDepartmentinDB(name);
			
//			PrintWriter out = response.getWriter();
//			out.print("Department Added Successfully");
			JOptionPane optionPane = new JOptionPane("Department Added Successfully",JOptionPane.WARNING_MESSAGE);
			JDialog dialog = optionPane.createDialog("Warning!");
			dialog.setAlwaysOnTop(true); // to show top of all other application
			dialog.setVisible(true); // to visible the dialog
		}
		else {
			doGet(request, response);
		}
	}

}
