package IngSoft.administracion.reserva;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.CriterioReservaBeanFunction;
import IngSoft.administracion.bean.PersonaBeanData;
import IngSoft.administracion.bean.ReservaBeanData;
import IngSoft.administracion.bean.ReservaBeanFunction;
import IngSoft.administracion.bean.ResultadoReservaBeanData;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

public class AccionConsultarReserva extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		
		
		System.out.print("cosnulta del codigo --->"+ request.getParameter("codigo"));
		ReservaBeanFunction reservaFuncion= ReservaBeanFunction.getInstance(); 
		ReservaBeanData reserva=reservaFuncion.consultarReserva(request.getParameter("codigo"));
       
		Vector<PersonaBeanData> personas=reservaFuncion.getAllpersonas();
		
		request.setAttribute("personas", personas);
		request.setAttribute("reserva", reserva);
		this.direccionar(sc, request, response, "/IngSoft/administracion/reserva/consultarreserva.jsp");
		

	}


}
