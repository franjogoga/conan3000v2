package IngSoft.venta.socio;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.DistritoMiniBeanData;
import IngSoft.venta.bean.MembresiaBeanFunction;
import IngSoft.venta.bean.PersonaMiniBeanData;
import IngSoft.venta.bean.PersonaMiniBeanFuncion;
import IngSoft.venta.bean.SocioBeanData;
import IngSoft.venta.bean.SocioBeanFuncion;

public class AccionAgregarMiniSocio extends CoAccion{


	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
				
				int tipo=Integer.parseInt(request.getParameter("tipo"));
				if(tipo==2){
					
					SocioBeanFuncion socioFuncion= SocioBeanFuncion.getInstanceS();
					SocioBeanData socioData=socioFuncion.crearSocio(request, response);

					socioFuncion.agregarSocio(socioData);
					
					PersonaMiniBeanFuncion personaFuncion=PersonaMiniBeanFuncion.getInstanceP();
					PersonaMiniBeanData personaData=personaFuncion.crearPersona(request, response);
					personaFuncion.agregarPersona(personaData);
					
					MembresiaBeanFunction membresiaFuncion=MembresiaBeanFunction.getInstance();
					//MembresiaBeanData membresiaData2=new MembresiaBeanData();
				
					//request.setAttribute("membresia2", membresiaData2);
					request.setAttribute("socio", socioData);

					this.direccionar(sc, request, response, "/IngSoft/ventas/socio/buscarsocio.jsp");
					//request.setAttribute("typeahead7",codigo);
				
				}
				SocioBeanFuncion socioFunction= SocioBeanFuncion.getInstanceS();
				Vector<DistritoMiniBeanData> distritoMiniData=socioFunction.getDistritos();
				//Vector<TipoEventoMiniBeanData> tipoEventoMiniData=eventoFunction.getTipoEvento();				
				
				request.setAttribute("tiposDistrito",distritoMiniData);
				
				this.direccionar(sc, request, response, "/IngSoft/ventas/socio/agregarsocio.jsp");
				}
	
}
