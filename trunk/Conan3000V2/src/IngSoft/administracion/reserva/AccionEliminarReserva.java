package IngSoft.administracion.reserva;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.PersonaBeanData;
import IngSoft.administracion.bean.ReservaBeanFunction;
import IngSoft.administracion.bean.ReservaBeanData;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

public class AccionEliminarReserva extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			
			
			System.out.print("  codigo antes---> "+   request.getParameter("codigo") );
			
			ReservaBeanFunction reservaFuncion= ReservaBeanFunction.getInstance();
			reservaFuncion.eliminarReserva(request.getParameter("codigo"));
			
			System.out.print(" codigo despues " +  request.getParameter("codigo") );
			
			this.direccionar(sc, request, response, "/IngSoft/administracion/reserva/buscarreserva.jsp");
			
		}
		else
		{	
			ReservaBeanFunction reservaFuncion= ReservaBeanFunction.getInstance(); 
			ReservaBeanData reserva=reservaFuncion.consultarReserva(request.getParameter("codigo"));
	       
			Vector<PersonaBeanData> personas=reservaFuncion.getAllpersonas();
			
			request.setAttribute("personas", personas);
			request.setAttribute("reserva", reserva);
		this.direccionar(sc, request, response, "/IngSoft/administracion/reserva/eliminarreserva.jsp");
		}

	}

}
