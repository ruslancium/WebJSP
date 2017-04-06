package name.ruslan.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import name.ruslan.dbservice.Service;

@WebServlet("/usersview")
public class UsersView extends HttpServlet {
	 @Override
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {		  
	     request.setAttribute("name", Service.getInstance().getUsers());
	     RequestDispatcher view = request.getRequestDispatcher("/jsp/showusers.jsp");
	        view.forward(request, response);
	 }
}
