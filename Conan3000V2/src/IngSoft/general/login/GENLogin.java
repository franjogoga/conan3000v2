package IngSoft.general.login;

import IngSoft.general.CoServlet;

public class GENLogin extends CoServlet {

	@Override
	protected void initAcciones() {
		acciones.put("Login", new AccionLogin());
		acciones.put("Logout", new AccionLogout());

	}

}
