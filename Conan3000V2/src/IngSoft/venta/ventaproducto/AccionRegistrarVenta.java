package IngSoft.venta.ventaproducto;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.*;



public class AccionRegistrarVenta extends CoAccion{
	
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
				
				
				
				int tipo=Integer.parseInt(request.getParameter("tipo"));
				if(tipo==2){
					
					//TrasladoBeanFuncion trasladoFuncion= TrasladoBeanFuncion.getInstance();
					//TrasladoBeanData trasladoData=trasladoFuncion.crearTraslado(request, response);
					
					
					
					//SocioBeanFuncion socioFuncion= SocioBeanFuncion.getInstanceS();
					//SocioBeanData socioData=socioFuncion.crearSocio(request, response);
					//socioData.setIdMembresia("MEM000032");
					//socioFuncion.agregarSocio(socioData);
					
					//PersonaMiniBeanFuncion personaFuncion=PersonaMiniBeanFuncion.getInstanceP();
					//PersonaMiniBeanData personaData=personaFuncion.crearPersona(request, response);
					//personaFuncion.agregarPersona(personaData);
					
					//MembresiaBeanFunction membresiaFuncion=MembresiaBeanFunction.getInstance();
					//MembresiaBeanData membresiaData2=new MembresiaBeanData();
					//membresiaData2.setIdMembresia(request.getParameter("txtIdMembresiaAntiguo"));
					//membresiaFuncion.agregarMembresia(membresiaData);
					
					
					//trasladoFuncion.agregarTraslado(trasladoData);
				
					//request.setAttribute("membresia2", membresiaData2);
					//request.setAttribute("socio", socioData);

					//this.direccionar(sc, request, response, "/IngSoft/ventas/membresia/trasladomembresia.jsp");
					//request.setAttribute("typeahead7",codigo);
				
				}
				//SocioBeanFuncion socioFunction= SocioBeanFuncion.getInstanceS();
				//Vector<DistritoMiniBeanData> distritoMiniData=socioFunction.getDistritos();
				//Vector<TipoEventoMiniBeanData> tipoEventoMiniData=eventoFunction.getTipoEvento();
				//Vector<AmbienteMiniBeanData> AmbienteMiniData=eventoFunction.getAmbientes();
				//request.setAttribute("sedes",sedeMiniData );
				//request.setAttribute("ambientes",AmbienteMiniData );
				
				
				//request.setAttribute("tiposDistrito",distritoMiniData);
				
				this.direccionar(sc, request, response, "/IngSoft/ventas/ventaproducto/buscarventaproducto.jsp");
				}
}
