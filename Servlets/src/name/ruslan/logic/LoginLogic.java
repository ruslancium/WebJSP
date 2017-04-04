package name.ruslan.logic;

import name.ruslan.dbservice.Service;

public class LoginLogic {
	//private final static String ADMIN_LOGIN = "admin";
	//private final static String ADMIN_PASS = "Qwe123";
	
	public static boolean checkLogin(String enterLogin, String enterPass) {
		//return ADMIN_LOGIN.equals(enterLogin) && ADMIN_PASS.equals(enterPass);
		String pass = Service.getInstance().getPassword(enterLogin);
		return enterPass.equals(pass);
	}
}
