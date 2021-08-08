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
import com.beans.Regulations;
import com.dao.AdminRegActions;

/**
 * Servlet implementation class AdminRegServlet
 */
public class AdminRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int compId = Integer.parseInt(request.getParameter("compId"));
		Regulations reg = AdminRegActions.viewRegulationsFromDB(compId);
		
		PrintWriter out = response.getWriter();
		if(reg != null) {
			out.println("Regulation Id - " + reg.getRegId() +"<br />");
			out.println("RL Type - " + reg.getRegType() +"<br />");
			out.println("Details - " + reg.getDetails() +"<br />");
			out.println("Create Date - " + reg.getCreateDate() +"<br />");
			out.println("Department Name - " + reg.getDept().getName() +"<br />");
		}
		else {
//			out.print("No regulation with ID: " + compId);
			JOptionPane optionPane = new JOptionPane("No regulation with ID: " + compId,JOptionPane.WARNING_MESSAGE);
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
		if(request.getParameter("action").equalsIgnoreCase("createReg")) {
			Department d = new Department(request.getParameter("dep"));
			Regulations r = new Regulations(request.getParameter("rltype"), request.getParameter("details"), java.sql.Date.valueOf(request.getParameter("createdate")), d);
			System.out.println(r);
			AdminRegActions.insertRegulationsIntoDB(r);
//			PrintWriter out = response.getWriter();
			JOptionPane optionPane = new JOptionPane("Regulation added Successfully",JOptionPane.WARNING_MESSAGE);
			JDialog dialog = optionPane.createDialog("Warning!");
			dialog.setAlwaysOnTop(true); // to show top of all other application
			dialog.setVisible(true); // to visible the dialog
//			out.print("Regulation added Successfully");
		}
		else {
			doGet(request, response);
			return;
		}
	}

}
