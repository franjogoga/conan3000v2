package IngSoft.venta.socio;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.PersonaMiniBeanData;
import IngSoft.venta.bean.PersonaMiniBeanFuncion;
import IngSoft.venta.bean.SocioBeanData;
import IngSoft.venta.bean.SocioBeanFuncion;
@SessionScoped
public class AccionConsultarSocio extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		
		String codigo=request.getParameter("codigo");
		
		PersonaMiniBeanFuncion PersonaFuncion=PersonaMiniBeanFuncion.getInstanceP();
		SocioBeanFuncion SocioFuncion= SocioBeanFuncion.getInstanceS();
		
		SocioBeanData SocioData=SocioFuncion.consultarSocio(codigo);
		PersonaMiniBeanData PersonaData=PersonaFuncion.consultarPersona(codigo);
		
		
		request.setAttribute("socio", SocioData);
		request.setAttribute("persona", PersonaData);

		this.direccionar(sc, request, response, "/IngSoft/ventas/socio/consultarsocio.jsp");
	}
	
}
