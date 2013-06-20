package IngSoft.administracion.reserva;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.ReservaBeanFunction;
import IngSoft.administracion.bean.ReservaBeanData;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

public class AccionEliminarReserva extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			
			
			ReservaBeanFunction reservaFuncion= ReservaBeanFunction.getInstance();
			reservaFuncion.eliminarReserva(request.getParameter("codigo"));
			
			System.out.print(" AccionEliminarReserva " +  request.getParameter("codigo") );
			
			this.direccionar(sc, request, response, "/IngSoft/administracion/reserva/buscarreserva.jsp");
			
		}
		else
		{	
		ReservaBeanFunction reservaFuncion= ReservaBeanFunction.getInstance(); 
		ReservaBeanData reservaData=reservaFuncion.consultarReserva(request.getParameter("codigo"));
		
      
		
		request.setAttribute("reserva",reservaData );
		this.direccionar(sc, request, response, "/IngSoft/administracion/reserva/eliminarreserva.jsp");
		}

	}

}
