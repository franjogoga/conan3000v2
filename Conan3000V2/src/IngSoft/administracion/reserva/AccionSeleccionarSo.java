package IngSoft.administracion.reserva;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;


import IngSoft.administracion.bean.CriterioEmpleadoBeanData;
import IngSoft.administracion.bean.CriterioEmpleadoBeanFunction;
import IngSoft.administracion.bean.CriterioReservaBeanData;
import IngSoft.administracion.bean.CriterioReservaBeanFunction;
import IngSoft.administracion.bean.CriterioSoBeanData;
import IngSoft.administracion.bean.CriterioSoBeanFunction;


import IngSoft.administracion.bean.ResultadoSoBeanData;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;


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
