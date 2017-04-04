package name.ruslan.command.client;

import name.ruslan.command.ActionCommand;
import name.ruslan.command.LoginCommand;
import name.ruslan.command.LogoutCommand;

public enum CommandEnum {
	LOGIN {
		{
			this.command = new LoginCommand();
		}
		},
	LOGOUT {
		{
			this.command = new LogoutCommand();
		}
	};
		
	ActionCommand command;
	
	public ActionCommand getCurrentCommand() {
		return command;
	}

}
