package IngSoft.venta.familiar;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.FamiliarBeanData;
import IngSoft.venta.bean.FamiliarBeanFuncion;
import IngSoft.venta.bean.PersonaMiniBeanData;
import IngSoft.venta.bean.PersonaMiniBeanFuncion;
@SessionScoped
public class AccionAgregarFamiliar extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
	
				int tipo=Integer.parseInt(request.getParameter("tipo"));
				if(tipo==2){
					FamiliarBeanFuncion familiarFuncion= FamiliarBeanFuncion.getInstance();
					PersonaMiniBeanFuncion personaFuncion=PersonaMiniBeanFuncion.getInstanceP();
					
					FamiliarBeanData familiarData=familiarFuncion.crearFamiliar(request, response);
					PersonaMiniBeanData personaData=personaFuncion.crearPersona(request, response);
					
					familiarFuncion.agregarFamiliar(familiarData);
					familiarFuncion.agregarPersona(personaData);
					
					this.direccionar(sc, request, response, "/IngSoft/ventas/familia/buscarfamiliar.jsp");
				}
				
				this.direccionar(sc, request, response, "/IngSoft/ventas/familia/agregarfamiliar.jsp");
		
	}

}
