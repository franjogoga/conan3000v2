package IngSoft.venta.socio;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.PersonaMiniBeanData;
import IngSoft.venta.bean.PersonaMiniBeanFuncion;
import IngSoft.venta.bean.SocioBeanData;
import IngSoft.venta.bean.SocioBeanFuncion;

public class AccionModificarSocio extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		SocioBeanFuncion SocioFuncion= SocioBeanFuncion.getInstanceS();
		PersonaMiniBeanFuncion PersonaFuncion=PersonaMiniBeanFuncion.getInstanceP();
		String codigo=request.getParameter("codigo");
				
		if(Integer.valueOf(request.getParameter("tipo"))==2){
	
			SocioBeanData SocioData=SocioFuncion.crearSocio(request, response);
			PersonaMiniBeanData PersonaData=PersonaFuncion.crearPersona(request, response);
			
			SocioData.setCodigo(codigo);
			PersonaData.setCodigo(codigo);
			
			SocioFuncion.modificarSocio(SocioData);
			PersonaFuncion.modificarPersona(PersonaData);
			
			this.direccionar(sc, request, response, "/IngSoft/ventas/socio/buscarsocio.jsp");
		}	
		
		SocioBeanData SocioData=SocioFuncion.consultarSocio(codigo);
		PersonaMiniBeanData PersonaData=PersonaFuncion.consultarPersona(codigo);  
		
		request.setAttribute("socio", SocioData);
		request.setAttribute("persona", PersonaData);
		this.direccionar(sc, request, response, "/IngSoft/ventas/socio/modificarsocio.jsp");
	}
}
