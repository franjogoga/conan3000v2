package IngSoft.venta.socio;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.DistritoMiniBeanData;
import IngSoft.venta.bean.SocioBeanData;
import IngSoft.venta.bean.SocioBeanFuncion;


public class AccionAgregarSocio extends CoAccion{
	
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
				int tipo=Integer.parseInt(request.getParameter("tipo"));
				if(tipo==2){
					SocioBeanFuncion socioFuncion= SocioBeanFuncion.getInstance();
					SocioBeanData socioData=socioFuncion.crearSocio(request, response);
					socioFuncion.agregarSocio(socioData);
					
					String codigo=socioData.getCodigo();
					
					
					//aca agregar el codigo para que se pase el codigo que se ha generado
					
					this.direccionar(sc, request, response, "/IngSoft/ventas/promociones/trasladomembresia.jsp");
					//request.setAttribute("typeahead7",codigo);
				
				}
				SocioBeanFuncion socioFunction= SocioBeanFuncion.getInstance();
				Vector<DistritoMiniBeanData> distritoMiniData=socioFunction.getDistritos();
				//Vector<TipoEventoMiniBeanData> tipoEventoMiniData=eventoFunction.getTipoEvento();
				//Vector<AmbienteMiniBeanData> AmbienteMiniData=eventoFunction.getAmbientes();
				//request.setAttribute("sedes",sedeMiniData );
				//request.setAttribute("ambientes",AmbienteMiniData );
				
				
				request.setAttribute("tiposDistrito",distritoMiniData);
				
				this.direccionar(sc, request, response, "/IngSoft/ventas/socio/agregarsocio.jsp");
				}
}
