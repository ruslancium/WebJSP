package name.ruslan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import name.ruslan.command.ActionCommand;
import name.ruslan.command.factory.ActionFactory;
import name.ruslan.resource.ConfigurationManager;
import name.ruslan.resource.MessageManager;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException {}
	
	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = null;
		// 		����������� �������, ��������� �� JSP
		ActionFactory client = new ActionFactory();
		ActionCommand command = client.defineCommand(request);
		
		/*
		 * ����� �������������� ������ execute() � �������� ����������
		 * ������-����������� ���������� �������
		 */
		page = command.execute(request);
		
		// ����� ���������� �������� ������		
		// page = null; // ��������������������!
		if (page != null) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
			// ����� �������� ������ �� ������
			dispatcher.forward(request, response);
		} else {
			// ��������� �������� c c��������� �� ������
			page = ConfigurationManager.getProperty("path.page.index");
			request.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
			response.sendRedirect(request.getContextPath() + page);
		}
	}
}
