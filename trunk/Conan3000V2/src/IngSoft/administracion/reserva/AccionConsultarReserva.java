package IngSoft.administracion.reserva;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.ReservaBeanData;
import IngSoft.administracion.bean.ReservaBeanFunction;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

public class AccionConsultarReserva extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		
		ReservaBeanFunction reservaFuncion= ReservaBeanFunction.getInstance(); 
		ReservaBeanData reservaData=reservaFuncion.consultarReserva(request.getParameter("codigo"));
		
        System.out.print(" codigo ---> "  + request.getParameter("codigo"));
		
		request.setAttribute("reserva",reservaData );
		this.direccionar(sc, request, response, "/IngSoft/administracion/reserva/consultarreserva.jsp");
		

	}


}
