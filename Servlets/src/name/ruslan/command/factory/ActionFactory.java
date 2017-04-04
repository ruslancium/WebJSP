package name.ruslan.command.factory;

import javax.servlet.http.HttpServletRequest;

import name.ruslan.command.ActionCommand;
import name.ruslan.command.EmptyCommand;
import name.ruslan.command.client.CommandEnum;
import name.ruslan.resource.MessageManager;

public class ActionFactory {
	
	public ActionCommand defineCommand(HttpServletRequest request) {
		ActionCommand current = new EmptyCommand();
		
		// ���������� ����� ������� �� �������		
		String action = request.getParameter("command");
		if (action == null || action.isEmpty()) {
			// ���� ������� �� ������ � ������� �������
			return current;
		}
		
		// ��������� �������, ���������������� �������		
		try {
			CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
			current = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
			request.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
		}
		
		return current;
	}

}
