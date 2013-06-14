package IngSoft.venta.familiar;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.FamiliarBeanData;
import IngSoft.venta.bean.FamiliarBeanFuncion;
import IngSoft.venta.bean.PersonaMiniBeanData;
import IngSoft.venta.bean.PersonaMiniBeanFuncion;


public class AccionConsultarFamiliar extends CoAccion{
	
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		String codigo=request.getParameter("codigo");
		
		PersonaMiniBeanFuncion PersonaFuncion=PersonaMiniBeanFuncion.getInstanceP();
		FamiliarBeanFuncion FamiliarFuncion= FamiliarBeanFuncion.getInstance();
		
		FamiliarBeanData FamiliarData=FamiliarFuncion.consultarFamiliar(codigo);
		PersonaMiniBeanData PersonaData=PersonaFuncion.consultarPersona(codigo);
		String codigoSocio=FamiliarData.getCodigoSocio();
		PersonaMiniBeanData PersonaSocioData=PersonaFuncion.consultarPersonaSocio(codigoSocio);
		//String nombre=PersonaSocioData.getNombres()+" "+PersonaSocioData.getApellidoPaterno()+" "+PersonaSocioData.getApellidoMaterno();
		//PersonaSocioData.setNombres(nombre);
		
		request.setAttribute("personaSocio", PersonaSocioData);
		request.setAttribute("familiar", FamiliarData);
		request.setAttribute("persona", PersonaData);

		this.direccionar(sc, request, response, "/IngSoft/ventas/familia/consultarfamiliar.jsp");
	}

}
