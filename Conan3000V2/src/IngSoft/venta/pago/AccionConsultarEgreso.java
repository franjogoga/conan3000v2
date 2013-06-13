package IngSoft.venta.pago;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.EgresoBeanData;
import IngSoft.venta.bean.EgresoBeanFunction;

public class AccionConsultarEgreso extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		EgresoBeanFunction EgresoFuncion= EgresoBeanFunction.getInstance();
		EgresoBeanData EgresoData=EgresoFuncion.consultarEgreso(request.getParameter("codigo"));

		request.setAttribute("egreso", EgresoData);

		this.direccionar(sc, request, response, "/IngSoft/ventas/pago/veregreso.jsp");
	}
	
}
