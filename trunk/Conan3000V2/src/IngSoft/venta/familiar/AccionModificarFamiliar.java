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

public class AccionModificarFamiliar extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		FamiliarBeanFuncion FamiliarFuncion= FamiliarBeanFuncion.getInstance();
		PersonaMiniBeanFuncion PersonaFuncion=PersonaMiniBeanFuncion.getInstanceP();
		String codigo=request.getParameter("codigo");
				
		if(Integer.valueOf(request.getParameter("tipo"))==2){
	
			FamiliarBeanData FamiliarData=FamiliarFuncion.crearFamiliar(request, response);
			PersonaMiniBeanData PersonaData=PersonaFuncion.crearPersona(request, response);
			
			FamiliarData.setCodigoFamiliar(codigo);
			PersonaData.setCodigo(codigo);
			
			FamiliarFuncion.modificarFamiliar(FamiliarData);
			PersonaFuncion.modificarPersona(PersonaData);
			
			this.direccionar(sc, request, response, "/IngSoft/ventas/familia/buscarfamiliar.jsp");
		}	
		
		FamiliarBeanData FamiliarData=FamiliarFuncion.consultarFamiliar(codigo);
		PersonaMiniBeanData PersonaData=PersonaFuncion.consultarPersona(codigo);  
		
		request.setAttribute("socio", FamiliarData);
		request.setAttribute("persona", PersonaData);
		this.direccionar(sc, request, response, "/IngSoft/ventas/familia/modificarfamiliar.jsp");
	}
	
}
