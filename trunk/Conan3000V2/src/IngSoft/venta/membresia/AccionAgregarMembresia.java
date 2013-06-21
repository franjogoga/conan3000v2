package IngSoft.venta.membresia;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

import IngSoft.venta.bean.MembresiaBeanData;
import IngSoft.venta.bean.MembresiaBeanFunction;

public class AccionAgregarMembresia extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				int tipo=Integer.parseInt(request.getParameter("tipo"));
				MembresiaBeanFunction membresiaFunction= MembresiaBeanFunction.getInstance();
				if(tipo==2){
					
					MembresiaBeanData membresiaData=membresiaFunction.crearMembresia(request, response);
					membresiaFunction.agregarMembresia(membresiaData);
					this.direccionar(sc, request, response, "/IngSoft/ventas/membresia/buscarmembresia.jsp");
				}
				
				MembresiaBeanData membresia=membresiaFunction.obtenerPrecio();
				

				request.setAttribute("membresia", membresia);
				
				
				this.direccionar(sc, request, response, "/IngSoft/ventas/membresia/agregarmembresia.jsp");
					
				//EventoBeanFuncion eventoFunction= EventoBeanFuncion.getInstance();
				//Vector<SedeMiniBeanData> sedeMiniData=eventoFunction.getSedes();
				//Vector<TipoEventoMiniBeanData> tipoEventoMiniData=eventoFunction.getTipoEvento();
				//Vector<AmbienteMiniBeanData> AmbienteMiniData=eventoFunction.getAmbientes();
				//request.setAttribute("sedes",sedeMiniData );
				//request.setAttribute("ambientes",AmbienteMiniData );
				//request.setAttribute("tiposEvento",tipoEventoMiniData);
				//this.direccionar(sc, request, response, "/IngSoft/servicio/evento/agregarevento.jsp");			
	}

}

