package IngSoft.administracion.reserva;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.CriterioReservaBeanData;
import IngSoft.administracion.bean.CriterioReservaBeanFunction;
import IngSoft.administracion.bean.ResultadoReservaBeanData;

public class AccionBuscarReserva extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		System.out.print("AccionBuscarReserva ---->");

		CriterioReservaBeanData criterioReservaData =new CriterioReservaBeanFunction().crearCriterio(request, response);
		Vector<ResultadoReservaBeanData> resultados=new CriterioReservaBeanFunction().buscarPlantillaReserva(criterioReservaData);

		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/administracion/reserva/buscarreserva.jsp");
		
	}

}
