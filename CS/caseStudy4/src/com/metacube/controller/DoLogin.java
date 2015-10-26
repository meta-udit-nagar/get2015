package com.metacube.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacube.MetaException;
import com.metacube.db.helper.AdminDbHelper;
import com.metacube.model.Admin;

/**
 * Servlet implementation class DoLogin
 */
@WebServlet("/DoLogin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
                   response.sendRedirect("view/login.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    	String username=request.getParameter("username");
	    	String password=request.getParameter("password");
	    	
	    	Admin admin= new Admin();
	    	admin.setPassword(password);
	    	admin.setUsername(username);
	    
	    	try {
				if(AdminDbHelper.isValidAdmin(admin))
				{
					HttpSession session= request.getSession();
					session.setAttribute("id", "id");
					response.sendRedirect("view/loggedin.jsp");
					
				}
				else
				{
					
					response.sendRedirect("view/login.jsp");
					
				}
			} catch (MetaException e) {
				// TODO Auto-generated catch block
				System.out.println("could not login from servlet");
			}
	    	
	}

}
