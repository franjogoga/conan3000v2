package IngSoft.administracion.reserva;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.CriterioSoBeanData;
import IngSoft.administracion.bean.CriterioSoBeanFunction;


import IngSoft.administracion.bean.ResultadoSoBeanData;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;


public class AccionSeleccionarSo extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		CriterioSoBeanData criterioSoData =new CriterioSoBeanFunction().crearCriterio(request, response);
		Vector<ResultadoSoBeanData> resultados=new CriterioSoBeanFunction().buscarPlantillaSo(criterioSoData);
		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/administracion/reserva/seleccionarsocio.jsp");
	
		}
	
	
	
	
	
	
	
	
}
