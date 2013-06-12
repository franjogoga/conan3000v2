package IngSoft.servicio.reserva;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.ReservaBeanFuncion;

public class AccionEliminarReserva extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		if(tipo==2){
			HttpSession sesion= request.getSession(true);
			Vector<String> listareservas=(Vector<String>)sesion.getAttribute("listareservas");
			listareservas=listareservas==null?new Vector<String>():listareservas;
			//String codSocio=request.getParameter("txtIdSocio");
			if(listareservas.size()>0){
				ReservaBeanFuncion reservaFuncion=ReservaBeanFuncion.getInstance();
				//reservaFuncion.agregarReservaBungalow(listareservas,codSocio);
				reservaFuncion.eliminarResevaBungalow(listareservas);
				sesion.removeAttribute("reservas");
				sesion.removeAttribute("listareservas");								
			}
		}
		if(tipo==3){
			HttpSession sesion= request.getSession(true);
			Vector<String> listareservas=(Vector<String>)sesion.getAttribute("listareservas");
			listareservas=listareservas==null?new Vector<String>():listareservas;
			//String codSocio=request.getParameter("txtIdSocio");			
			if(listareservas.size()>0){
				ReservaBeanFuncion reservaFuncion=ReservaBeanFuncion.getInstance();
				//reservaFuncion.agregarReservaCancha(listareservas,codSocio);
				sesion.removeAttribute("reservas");
				sesion.removeAttribute("listareservas");								
			}
		}
	}
		

	}


