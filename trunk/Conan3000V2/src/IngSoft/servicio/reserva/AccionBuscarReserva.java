package IngSoft.servicio.reserva;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.CriterioEventoBeanData;
import IngSoft.servicio.bean.CriterioEventoBeanFunction;
import IngSoft.servicio.bean.ReservaBeanFuncion;
import IngSoft.servicio.bean.ResultadoEventoBeanData;
import IngSoft.servicio.bean.SedeMiniBeanData;

public class AccionBuscarReserva extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		if(tipo==2){
			if("bungalow".equals(request.getParameter("cmbServicios")))
				
				this.direccionar(sc, request, response, "/IngSoft/servicio/reserva/reservaxdia.jsp");
			
			
			else this.direccionar(sc, request, response, "/IngSoft/servicio/reserva/reservaxhora.jsp");
			
		}
		if(tipo==3){
			if("bungalow".equals(request.getParameter("cmbServicios"))) 
				this.direccionar(sc, request, response, "/IngSoft/servicio/reserva/reservaxdia.jsp");
			else this.direccionar(sc, request, response, "/IngSoft/servicio/reserva/reservaxhora.jsp");
			
		}
		ReservaBeanFuncion reservaFuncion= ReservaBeanFuncion.getInstance();
		Vector<SedeMiniBeanData> sedeMiniData=reservaFuncion.getSedes();
		request.setAttribute("sedes",sedeMiniData );
		//request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/servicio/reserva/buscarreserva.jsp");
	}

}
