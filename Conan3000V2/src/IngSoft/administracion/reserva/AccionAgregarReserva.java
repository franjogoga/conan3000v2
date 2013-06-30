package IngSoft.administracion.reserva;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import IngSoft.administracion.bean.CriterioReservaBeanData;
import IngSoft.administracion.bean.CriterioReservaBeanFunction;
import IngSoft.administracion.bean.ReservaBeanData;
import IngSoft.administracion.bean.ReservaBeanFunction;
import IngSoft.administracion.bean.ResultadoReservaBeanData;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

public class AccionAgregarReserva extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			
			System.out.print( "-----> entro  agregar registro  txtCodigoSoc  -------->"   + request.getParameter("codigosocio")    );
			
		
		ReservaBeanFunction reservaFuncion= ReservaBeanFunction.getInstance();
		ReservaBeanData reservaData=reservaFuncion.crearReserva(request, response);
		reservaFuncion.agregarReserva(reservaData);
		
		this.direccionar(sc, request, response, "/IngSoft/administracion/reserva/buscarreserva.jsp");
		
			
		}
		else
		{	

		
			
			ReservaBeanFunction reservaFuncion= ReservaBeanFunction.getInstance(); 
			Vector<ReservaBeanData> reserva=reservaFuncion.consultarReservaInvitado(request.getParameter("codigo"));

			
			
			request.setAttribute("reserva", reserva);
			
			System.out.print("vamos agregar");
		   this.direccionar(sc, request, response, "/IngSoft/administracion/reserva/agregarreserva.jsp");
		}

	}

}
